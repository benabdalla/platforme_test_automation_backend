package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ConnexionDTO;
import com.saphir.platforme.entity.UtilisateurQualipro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UtilisateurQualiproRepository extends JpaRepository<UtilisateurQualipro, Long> {
    @Query(value="select u.id_user,u.login,u.password,u.name from utilisateur_qualipro u  where u.name=:name",nativeQuery = true)
    List<UtilisateurQualipro> findByName(@Param("name") String name);

}
