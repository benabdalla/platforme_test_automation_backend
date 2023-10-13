package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class DocumentationDto implements Serializable {

    private long idScenario;
    private int etat;
    private String filaileScenario;
    private  String  Libelle;
    private  String  docCode;
    private  String  objet;
    private SiteDto site;
    private ProcessusDto processus;
    private ActiviteDto activite;
    private DirectionDto direction;
    private TabServiceDto service;
    private TypeDocumentationDto typeDocumentation;
}
