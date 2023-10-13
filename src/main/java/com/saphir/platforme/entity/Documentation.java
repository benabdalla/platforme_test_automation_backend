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
public class Documentation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScenario;
    private int etat;
    @Column(length = 3000)
    private  String  Libelle;
    @Column(length = 3000)
    private  String  pathDoc;
    @Column(length = 3000)
    private  String  objet;
    @Column(length = 3000)
    private  String  docCode;
    @Column(length = 100)
    private String filaileScenario;
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
    @ManyToOne
    @JoinColumn(name = "idService")
    @JsonIgnore
    private TabService service;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "typeDocumentation", referencedColumnName = "idType")
    @JsonIgnore
    private TypeDocumentation typeDocumentation;
}
