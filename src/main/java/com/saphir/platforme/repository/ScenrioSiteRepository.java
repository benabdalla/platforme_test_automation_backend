package com.saphir.platforme.repository;

import com.saphir.platforme.entity.ScenarioSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScenrioSiteRepository extends JpaRepository<ScenarioSite, Long> {
    List<ScenarioSite> findBySiteIdSiteNotNull();

}
