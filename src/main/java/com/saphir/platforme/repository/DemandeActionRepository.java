package com.saphir.platforme.repository;

import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.DemandeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeActionRepository extends JpaRepository<DemandeAction, Long> {



}
