package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ReunionDto;
import com.saphir.platforme.entity.DemandeAction;
import com.saphir.platforme.entity.Reunion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReunionRepository {
    Reunion addReunion(ReunionDto reunion);

    List<ReunionDto> getAllReunion();

    Reunion findReunionByIDScenario(Long id);

    ReunionDto getReunionByIDScenario(Long id);

    ResponseEntity<Reunion> updateRenuion(Reunion reunion);



    void deleteRenuion(Long idSceanrio);

}
