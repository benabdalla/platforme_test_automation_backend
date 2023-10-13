package com.saphir.platforme.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TypeDocumentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    @Column(length = 3000)
    private String abreviation;
    @Column(length = 3000)
    private String typeDoc;
    private Integer  pdf;
    private Integer etat;
    private Integer periodicite_revue;
    private Integer nature ;
    @ManyToOne
    @JoinColumn(name = "superviseur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur superviseur;
    @ManyToOne
    @JoinColumn(name = "redacteur", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur redacteur;
    @ManyToOne
    @JoinColumn(name = "verificateurs", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur verificateurs;
    @ManyToOne
    @JoinColumn(name = "approbateur", referencedColumnName = "idUser")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) // Cascade the save operation
    private Utilisateur approbateur;
    @ManyToOne
    @JoinColumn(name = "accuse_reception", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur accuse_reception;
    @ManyToOne
    @JoinColumn(name = "responsables_gestion_diffusion", referencedColumnName = "idUser")
    @JsonIgnore
    private Utilisateur responsables_gestion_diffusion;







}
