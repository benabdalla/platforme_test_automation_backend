package com.saphir.platforme.repository;


import com.saphir.platforme.entity.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
    @Transactional
    @Modifying
    @Query("update Documentation set pathDoc =:path where  idScenario=:id")
    void updateForPathDoc(@Param("id") Long id,@Param("path") String path);
}
