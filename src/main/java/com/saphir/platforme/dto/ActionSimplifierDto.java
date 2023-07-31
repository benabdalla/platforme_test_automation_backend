package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
@Getter
@Setter
@Data
public class ActionSimplifierDto {


    private long idActionSimplifier;
    private int numFicheActionSimplifier;
    private int etat;
    private String filialeDeclencheurSimpl;
    private String filialeRealisationSimpl;
    private String filialeSuiviSimpl;
    private String filialeClotureSimpl;
    private String source;
    private String typeAction;
    private String designation;

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

    private UtilisateurDto dechlencheur;

    private UtilisateurDto respTraitement;

    private UtilisateurDto respCloture;

    private UtilisateurDto respSuivi;
}
