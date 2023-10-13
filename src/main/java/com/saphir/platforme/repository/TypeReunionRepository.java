package com.saphir.platforme.repository;

import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.entity.TypeReunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeReunionRepository extends JpaRepository<TypeReunion, Long> {



}
