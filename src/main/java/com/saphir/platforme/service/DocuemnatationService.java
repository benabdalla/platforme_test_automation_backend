package com.saphir.platforme.service;

import com.saphir.platforme.dto.DocumentationDto;
import com.saphir.platforme.entity.Documentation;
import com.saphir.platforme.entity.TypeDocumentation;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.mapper.DocumentationMapper;
import com.saphir.platforme.mapper.TypeDocumentMapper;
import com.saphir.platforme.mapper.UtilisateurMapper;
import com.saphir.platforme.repository.IDocumentationRepository;
import com.saphir.platforme.repository.DocumentationRepository;
import com.saphir.platforme.repository.TypeDocumentationRepository;
import com.saphir.platforme.repository.UtilisateurQualiproRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocuemnatationService implements IDocumentationRepository {
    private DocumentationMapper DocumentationMapper;
    private TypeDocumentMapper typeDocumentationMapper;
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    DocumentationRepository documentationRepository;
    @Autowired
    TypeDocumentationRepository typeDocumentationRepository;
    @Autowired
    UtilisateurQualiproRepository utilisateurQualiproRepository;


    @Autowired
    public DocuemnatationService(DocumentationMapper DocumentationMapper, UtilisateurMapper utilisateurMapper, TypeDocumentMapper typeDocumentationMapper) {
        this.DocumentationMapper = DocumentationMapper;
        this.typeDocumentationMapper = typeDocumentationMapper;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public Documentation addDocumentation(DocumentationDto documentationDto) {
        Utilisateur user, user1, user2, user3, user4, user5;
        Documentation act = DocumentationMapper.toEntity(documentationDto);
        TypeDocumentation typeDocumentation = typeDocumentationMapper.toEntity(documentationDto.getTypeDocumentation());
        act.setTypeDocumentation(typeDocumentation);
//
//        if (documentationDto.getTypeDocumentation().getSuperviseur().getIdUser() != null) {
//            user = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getSuperviseur().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setSuperviseur(user);
//        }
//
//        if (documentationDto.getTypeDocumentation().getRedacteur().getIdUser() != null) {
//            user1 = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getRedacteur().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setRedacteur(user1);
//        }
//        if (documentationDto.getTypeDocumentation().getVerificateurs().getIdUser() != null) {
//            user2 = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getVerificateurs().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setVerificateurs(user2);
//        }
//        if (documentationDto.getTypeDocumentation().getApprobateur().getIdUser() != null) {
//            user3 = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getApprobateur().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setApprobateur(user3);
//        }
//
//        if (documentationDto.getTypeDocumentation().getAccuse_reception().getIdUser() != null) {
//            user4 = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getAccuse_reception().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setAccuse_reception(user4);
//        }
//
//        if (documentationDto.getTypeDocumentation().getResponsables_gestion_diffusion().getIdUser() != null) {
//            user5 = utilisateurQualiproRepository.findById(documentationDto.getTypeDocumentation().getResponsables_gestion_diffusion().getIdUser()).orElse(null);
//            act.getTypeDocumentation().setResponsables_gestion_diffusion(user5);
//        }
//

        act = documentationRepository.save(act);
        return act;
    }

    @Override
    public List<DocumentationDto> getAllDocumentation() {
        List<Documentation> Documentations = documentationRepository.findAll();
        return DocumentationMapper.toDtos(Documentations);
    }

    @Override
    public Documentation findDocumentationByIDScenario(Long id) {
        //Documentation scenarioDocumentation =DocumentationRepository.findById(id).orElse(null);
        return documentationRepository.findById(id).orElse(null);
    }

    @Override
    public DocumentationDto getDocumentationByIDScenario(Long id) {
        Documentation Documentation = documentationRepository.getById(id);
        DocumentationDto DocumentationDto = DocumentationMapper.toDto(Documentation);
        return DocumentationDto;
    }

    @Override
    public ResponseEntity<Documentation> updateDocumentation(Documentation Documentation) {
        //  Documentation Documentation = DocumentationMapper.toEntity(DocumentationDto);
        if (documentationRepository.existsById(Documentation.getIdScenario())) {
            documentationRepository.save(Documentation);
        } else {
            // Action not found, handle the error or throw an exception
            throw new IllegalArgumentException("Action does not exist");
        }
        return ResponseEntity.ok(Documentation);
    }

    @Override
    public void updatePathDoc(Long idDoc, String urlPath) {
         documentationRepository.updateForPathDoc(idDoc,urlPath);
    }

    @Override
    public void deleteDocumentation(Long idSceanrio) {
        if (idSceanrio != null) {
            documentationRepository.deleteById(idSceanrio);
            typeDocumentationRepository.deleteById(idSceanrio);
        }
    }


}
