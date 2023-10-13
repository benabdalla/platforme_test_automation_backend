package com.saphir.platforme.repository;

import com.saphir.platforme.dto.DocumentationDto;
import com.saphir.platforme.entity.Documentation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDocumentationRepository {
    Documentation addDocumentation(DocumentationDto Documentation);

    List<DocumentationDto> getAllDocumentation();

    Documentation findDocumentationByIDScenario(Long id);

    DocumentationDto getDocumentationByIDScenario(Long id);

    ResponseEntity<Documentation> updateDocumentation(Documentation Documentation);
    void updatePathDoc(Long idDoc,String urlPath);



    void deleteDocumentation(Long idSceanrio);

}
