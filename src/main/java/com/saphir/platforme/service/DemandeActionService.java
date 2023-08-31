package com.saphir.platforme.service;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.DemandeActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.DemandeAction;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.mapper.ActionMapper;
import com.saphir.platforme.mapper.DemandeActionMapper;
import com.saphir.platforme.mapper.UtilisateurMapper;
import com.saphir.platforme.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeActionService implements IDemandeActionRepository {
    private DemandeActionMapper actionMapper;
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    DemandeActionRepository actionRepository;
    @Autowired
    UtilisateurQualiproRepository utilisateurQualiproRepository;


    @Autowired
    public DemandeActionService(DemandeActionMapper actionMapper, UtilisateurMapper utilisateurMapper) {
        this.actionMapper = actionMapper;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public DemandeAction addAction(DemandeActionDto actiondto) {
        Utilisateur user, user1,user2;
        DemandeAction act = actionMapper.toEntity(actiondto);

        if (actiondto.getDechlencheur().getIdUser() != null) {
            user = utilisateurQualiproRepository.findById(actiondto.getDechlencheur().getIdUser()).orElse(null);
            act.setDechlencheur(user);
        }
        if (actiondto.getRespSuivi().getIdUser() != null) {
            user = utilisateurQualiproRepository.findById(actiondto.getDechlencheur().getIdUser()).orElse(null);
            act.setDechlencheur(user);
        }
        if (actiondto.getRespTraitement().getIdUser() != null) {
            user1 = utilisateurQualiproRepository.findById(actiondto.getRespTraitement().getIdUser()).orElse(null);
            act.setRespTraitement(user1);
        }


        act = actionRepository.save(act);
        return act;
    }

    @Override
    public List<DemandeActionDto> getAllAction() {
        List<DemandeAction> demandeAction = actionRepository.findAll();
        return actionMapper.toDtos(demandeAction);
    }


    @Override
    public DemandeAction findActionByIDScenario(Long id) {
        //Action scenarioAction =actionRepository.findById(id);
        return actionRepository.findById(id).orElse(null);
    }

    @Override
    public DemandeActionDto getActionByIDScenario(Long id) {
        DemandeAction action = actionRepository.getById(id);
        DemandeActionDto actionDto = actionMapper.toDto(action);
        return actionDto;

    }


    @Override
    public ResponseEntity<DemandeAction> updateAction(DemandeAction action) {
        //Action action = actionMapper.toEntity(action);
        if (actionRepository.existsById(action.getIdScenario())) {
            actionRepository.save(action);
        } else {
            // Action not found, handle the error or throw an exception
            throw new IllegalArgumentException("Action does not exist");
        }
        return ResponseEntity.ok(action);
    }

    @Override
    public void deleteAction(Long idSceanrio) {
        if (idSceanrio != null) {
            actionRepository.deleteById(idSceanrio);
        }
    }


}
