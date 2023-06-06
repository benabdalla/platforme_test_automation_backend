package com.saphir.platforme.repository;

import com.saphir.platforme.entity.Parametrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParametreRepository extends JpaRepository<Parametrage, Long> {
}
