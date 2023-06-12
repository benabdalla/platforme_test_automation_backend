package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
@Getter
@Setter
@Entity
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScenario;
    private int numFiche;
//    private int etat;
//    private String filiale;
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
    @ManyToOne
    @JoinColumn(name = "dechlencheur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur dechlencheur;
    @ManyToOne
    @JoinColumn(name = "respTraitement", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur respTraitement;
    @ManyToOne
    @JoinColumn(name = "respCloture", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur respCloture;
    @ManyToOne
    @JoinColumn(name = "respSuivi", referencedColumnName = "idUser")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) // Cascade the save operation
    private Utilisateur respSuivi;


}
