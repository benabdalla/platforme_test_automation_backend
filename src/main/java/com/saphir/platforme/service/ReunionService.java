package com.saphir.platforme.service;

import com.saphir.platforme.dto.ReunionDto;
import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.entity.TypeReunion;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.mapper.ReunionMapper;
import com.saphir.platforme.mapper.TypeReunionMapper;
import com.saphir.platforme.mapper.UtilisateurMapper;
import com.saphir.platforme.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionService implements IReunionRepository {
    private ReunionMapper reunionMapper;
    private TypeReunionMapper typeReunionMapper;
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    ReunionRepository reunionRepository;
    @Autowired
    UtilisateurQualiproRepository utilisateurQualiproRepository;


    @Autowired
    public ReunionService(ReunionMapper reunionMapper, UtilisateurMapper utilisateurMapper,TypeReunionMapper typeReunionMapper) {
        this.reunionMapper = reunionMapper;
        this.typeReunionMapper = typeReunionMapper;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public Reunion addReunion(ReunionDto reunionDto) {
     Utilisateur user, user1,user2;
        Reunion act = reunionMapper.toEntity(reunionDto);
        TypeReunion typeReunion = typeReunionMapper.toEntity(reunionDto.getTypeReunion());
        act.setTypeReunion(typeReunion);

        if (reunionDto.getTypeReunion().getDechlencheur().getIdUser() != null) {
            user = utilisateurQualiproRepository.findById(reunionDto.getTypeReunion().getDechlencheur().getIdUser()).orElse(null);
            act.getTypeReunion().setDechlencheur(user);
        }
        if (reunionDto.getTypeReunion().getPourInfo().getIdUser() != null) {
            user1 = utilisateurQualiproRepository.findById(reunionDto.getTypeReunion().getPourInfo().getIdUser()).orElse(null);
            act.getTypeReunion().setPourInfo(user1);
        }

       act = reunionRepository.save(act);
    return act;
    }

    @Override
    public List<ReunionDto> getAllReunion() {
        List<Reunion> reunions = reunionRepository.findAll();
        return reunionMapper.toDtos(reunions);
    }

    @Override
    public Reunion findReunionByIDScenario(Long id) {
                //Reunion scenarioReunion =reunionRepository.findById(id).orElse(null);
        return reunionRepository.findById(id).orElse(null);
    }

    @Override
    public ReunionDto getReunionByIDScenario(Long id) {
        Reunion reunion = reunionRepository.getById(id);
       ReunionDto reunionDto = reunionMapper.toDto(reunion);
      return reunionDto;
    }

    @Override
    public ResponseEntity<Reunion> updateRenuion(Reunion reunion) {
      //  Reunion reunion = reunionMapper.toEntity(reunionDto);
        if (reunionRepository.existsById(reunion.getIdScenario())) {
            reunionRepository.save(reunion);
        } else {
            // Action not found, handle the error or throw an exception
            throw new IllegalArgumentException("Action does not exist");
        }
        return ResponseEntity.ok(reunion);
    }

    @Override
    public void deleteRenuion(Long idSceanrio) {
        if (idSceanrio != null) {
          reunionRepository.deleteById(idSceanrio);

       }
    }





}
