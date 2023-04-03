package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ConnexionDTO;
import com.saphir.platforme.entity.UtilisateurQualipro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UtilisateurQualiproRepository extends JpaRepository<UtilisateurQualipro,Long> {
    List<ConnexionDTO> findByName(String name);

}
