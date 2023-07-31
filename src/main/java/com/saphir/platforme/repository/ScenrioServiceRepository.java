package com.saphir.platforme.repository;

import com.saphir.platforme.entity.ScenarioService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScenrioServiceRepository extends JpaRepository<ScenarioService, Long> {

    List<ScenarioService> findByTabServiceIdServiceNotNull();

}
