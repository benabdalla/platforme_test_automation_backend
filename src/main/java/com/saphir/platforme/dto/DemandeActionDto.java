package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.Utilisateur;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemandeActionDto {

    private long idScenario;
    private int numFiche;
    private int etat;
    private String filialeDeclencheur;
    private String filialeRealisation;
    private String source;
    private String typeAction;
    private String typeCause;
    private String designation;
    private String description;
    private SiteDto site;
    private ProcessusDto processus;
    private ActiviteDto activite;
    private DirectionDto direction;
    private TabServiceDto service;
    private String desiSA;
    private String dateRealisation;
    private String tauxRealisation;
    private String dateSuivi;
    private String tauxSuivi;
    private String dateCreation;
    private String produit;
    private UtilisateurDto dechlencheur;
    private UtilisateurDto respTraitement;
    private Utilisateur respReal;
    private Utilisateur respSuivi;


}
