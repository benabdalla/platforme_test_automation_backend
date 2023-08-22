package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.DemandeActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.DemandeAction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDemandeActionRepository {
    DemandeAction addAction(DemandeActionDto action);

    List<DemandeActionDto> getAllAction();

    DemandeAction findActionByIDScenario(Long id);

    DemandeActionDto getActionByIDScenario(Long id);

    ResponseEntity<DemandeAction> updateAction(DemandeAction action);

    void deleteAction(Long idSceanrio);

}
