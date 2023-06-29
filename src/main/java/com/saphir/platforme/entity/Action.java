package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Service;

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
    @ManyToOne
    @JoinColumn(name = "idSite")
    @JsonIgnore
    private Site site;
    @ManyToOne
    @JoinColumn(name = "idProcessus")
    @JsonIgnore
    private Processus processus;
    @ManyToOne
    @JoinColumn(name = "idActivite")
    @JsonIgnore
    private Activite activite;
    @ManyToOne
    @JoinColumn(name = "idDirection")
    @JsonIgnore
    private Direction direction;
    @JoinColumn(name = "idService")
    @JsonIgnore
    private TabService service;
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
