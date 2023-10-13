package com.saphir.platforme.repository;


import com.saphir.platforme.entity.Documentation;
import com.saphir.platforme.entity.TypeDocumentation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDocumentationRepository extends JpaRepository<TypeDocumentation, Long> {
}
