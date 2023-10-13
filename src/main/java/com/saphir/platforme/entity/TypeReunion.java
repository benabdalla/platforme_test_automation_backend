package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TypeReunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    @Column(length = 3000)
    private String  typeReunion;
    @Column(length = 3000)
    private String  periodicite;
    @ManyToOne
    @JoinColumn(name = "dechlencheur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur dechlencheur;
    @ManyToOne
    @JoinColumn(name = "pourInfo", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur pourInfo;
    @Column(length = 3000)
    private String filialeDeclencheur;
    @Column(length = 3000)
    private String filialeRealisation;

}
