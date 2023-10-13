package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.Utilisateur;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TypeReunionDto {

    private Long idType;
    private String  typeReunion;
    private String  periodicite;
    private Utilisateur dechlencheur;
    private Utilisateur pourInfo;
    private String filialeDeclencheur;
    private String filialeRealisation;

}
