package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;

import java.util.List;

public interface IActionRepository {
    Action addAction(ActionDto action);

    List<ActionDto> getAllAction();
    Action findActionByIDScenario(Long id);
}
