package com.saphir.platforme.service;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.mapper.ActionMapper;
import com.saphir.platforme.mapper.UtilisateurMapper;
import com.saphir.platforme.repository.ActionRepository;
import com.saphir.platforme.repository.IActionRepository;
import com.saphir.platforme.repository.UtilisateurQualiproRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService implements IActionRepository {
    private ActionMapper actionMapper;
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    ActionRepository actionRepository;
    @Autowired
    UtilisateurQualiproRepository utilisateurQualiproRepository;


    @Autowired
    public ActionService(ActionMapper actionMapper, UtilisateurMapper utilisateurMapper) {
        this.actionMapper = actionMapper;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public Action addAction(ActionDto actiondto) {
        Utilisateur user, user1, user2, user3;
        Action act = actionMapper.toEntity(actiondto);
        if (actiondto.getDechlencheur().getIdUser() != null) {
            user = utilisateurQualiproRepository.findById(actiondto.getDechlencheur().getIdUser()).orElse(null);
            act.setDechlencheur(user);
        }

        if (actiondto.getRespSuivi().getIdUser() != null) {
            user1 = utilisateurQualiproRepository.findById(actiondto.getRespSuivi().getIdUser()).orElse(null);
            act.setRespSuivi(user1);
        }
        if (actiondto.getRespSuivi().getIdUser() != null) {
            user2 = utilisateurQualiproRepository.findById(actiondto.getRespTraitement().getIdUser()).orElse(null);
            act.setRespTraitement(user2);
        }
        if (actiondto.getRespSuivi().getIdUser() != null) {
            user3 = utilisateurQualiproRepository.findById(actiondto.getRespCloture().getIdUser()).orElse(null);
            act.setRespCloture(user3);
        }
        return actionRepository.save(act);
    }

    @Override
    public List<ActionDto> getAllAction(int id) {
        List<Action> action = actionRepository.findByActSimplifier(id);
        List<ActionDto> actionDtos = actionMapper.toDtos(action);

        return actionDtos;
    }

    @Override
    public Action findActionByIDScenario(Long id) {
        //Action scenarioAction =actionRepository.findById(id);
        return actionRepository.findById(id).orElse(null);
    }

    @Override
    public ActionDto getActionByIDScenario(Long id) {
        Action action = actionRepository.getById(id);
        ActionDto actionDto = actionMapper.toDto(action);
        return actionDto;

    }

    @Override
    public List<ActionDto> getAllActionSimplifier(int id) {
        List<Action> action = actionRepository.findByActSimplifier(id);
        List<ActionDto> actionDto = actionMapper.toDtos(action);
        return actionDto;

    }

    @Override
    public ResponseEntity<Action> updateAction(Action action) {
        //Action action = actionMapper.toEntity(actiondto);
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
