package com.saphir.platforme.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionDto {

        private long idScenario;
        private int numFiche;
        private int etat;
        private int actSimplifier;
        private String filialeDeclencheur;
        private String filialeRealisation;
        private String filialeSuivi;
        private String filialeCloture;
        private String source;
        private String  typeAction;
        private String priorite;
        private String gravite;
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
        private UtilisateurDto respCloture;
        private UtilisateurDto respSuivi;





}
