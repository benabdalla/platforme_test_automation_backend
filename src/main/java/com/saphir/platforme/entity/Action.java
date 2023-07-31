package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScenario;
    private int numFiche;
    private int etat;
    private int actSimplifier;
    @Column(length = 3000)
    private String filialeDeclencheur;
    @Column(length = 3000)
    private String filialeRealisation;
    @Column(length = 3000)
    private String filialeSuivi;
    @Column(length = 3000)
    private String filialeCloture;
    @Column(length = 3000)
    private String source;
    @Column(length = 3000)
    private String typeAction;
    @Column(length = 3000)
    private String priorite;
    @Column(length = 3000)
    private String gravite;
    @Column(length = 3000)
    private String typeCause;
    @Column(length = 3000)
    private String designation;
    @Column(length = 3000)
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
    @Column(length = 3000)
    private String desiSA;
    @Column(length = 3000)
    private String dateRealisation;
    @Column(length = 3000)
    private String tauxRealisation;
    @Column(length = 3000)
    private String dateSuivi;
    @Column(length = 3000)
    private String tauxSuivi;
    @Column(length = 3000)
    private String dateCreation;
    @Column(length = 3000)
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
