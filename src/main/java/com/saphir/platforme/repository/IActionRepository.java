package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IActionRepository {
    Action addAction(ActionDto action);

    List<ActionDto> getAllAction(int id);

    Action findActionByIDScenario(Long id);

    ActionDto getActionByIDScenario(Long id);

    ResponseEntity<Action> updateAction(Action action);

    ResponseEntity<Action> deleteAction(Long idSceanrio);

    List<ActionDto> getAllActionSimplifier(int actSimplifier);
}
