package com.saphir.platforme.repository;

import com.saphir.platforme.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findByActSimplifier(int actSimplifier);


}
