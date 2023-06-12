package com.saphir.platforme.service;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.mapper.ActionMapper;
import com.saphir.platforme.repository.ActionRepository;
import com.saphir.platforme.repository.IActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService implements IActionRepository {
    private final ActionMapper actionMapper;
    @Autowired
    ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionMapper actionMapper) {
        this.actionMapper = actionMapper;
    }

    @Override
    public Action addAction(ActionDto actiondto) {

        Action act = actionMapper.toEntity(actiondto);

        return actionRepository.save(act);
    }

    @Override
    public List<ActionDto> getAllAction() {
        List<Action> action = actionRepository.findAll();
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
    public ResponseEntity<Action> deleteAction(Long idSceanrio) {
        if (idSceanrio != null) {
            actionRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }


}
