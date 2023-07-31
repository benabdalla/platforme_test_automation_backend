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
public class ScenarioActivite {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScenarioActivite;
    @Column(length = 3000)
    private String filialeDeclencheur;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idActivite", referencedColumnName = "idActivite")
    private Activite activite;
    @ManyToOne
    @JoinColumn(name = "dechlencheur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur dechlencheur;


}
