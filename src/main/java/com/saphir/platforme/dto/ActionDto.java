package com.saphir.platforme.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {
    private long idScenario;
    private int numFiche;
    private String source;
    private String type;
    private String priorite;
    private String gravite;
    private String typeCause;
    private String designation;
    private String description;
    private String site;
    private String processus;
    private String activite;
    private String direction;
    private String service;
    private String desiSA;
    private String dateRealisation;
    private String tauxRealisation;
    private String dateSuivi;
    private String tauxSuivi;
    private String dateCreation;
    private String produit;
    private UtilisateurDto dechlencheur;
    private UtilisateurDto respTraitement;
    private UtilisateurDto respCloture;
    private UtilisateurDto respSuivi;


}
