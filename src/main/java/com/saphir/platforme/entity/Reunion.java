package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reunion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScenario;
    private int numFiche;
    @Column(length = 3000)
    private String  datePrevue;
    @Column(length = 3000)
    private String  lieu;
    @Column(length = 3000)
    private String type;
    @Column(length = 3000)
    private  String  orderJour;
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
    @ManyToOne
    @JoinColumn(name = "dechlencheur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur participant;


}
