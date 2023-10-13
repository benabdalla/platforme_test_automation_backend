package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.Utilisateur;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReunionDto {
    private long idScenario;
    private int numFiche;
    private int etat;
    private String datePrevue;
    private String lieu;
    private String type;
    private String orderJour;
    private SiteDto site;
    private ProcessusDto processus;
    private ActiviteDto activite;
    private DirectionDto direction;
    private TabServiceDto service;
    private TypeReunionDto typeReunion;


}
