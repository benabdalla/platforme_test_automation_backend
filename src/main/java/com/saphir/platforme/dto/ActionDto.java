package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {
        private long idScenario;
        private int numFiche;
        private int etat;
        private String filialeDeclencheur;
        private String filialeRealisation;
        private String filialeSuivi;
        private String filialeCloture;
        private String source;
        private String type;
        private String priorite;
        private String gravite;
        private String typeCause;
        private String designation;
        private String description;
        private Site site;
        private Processus processus;
        private Activite activite;
        private Direction direction;
        private TabService service;
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
