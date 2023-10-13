package com.saphir.platforme.dto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TypeDocumentationDto {

    private Long idType;

    private String abreviation;

    private String typeDoc;
    private Integer pdf;
    private Integer etat;
    private Integer periodicite_revue;
    private Integer nature;
    private UtilisateurDto superviseur;
    private UtilisateurDto redacteur;
    private UtilisateurDto verificateurs;
    private UtilisateurDto approbateur;
    private UtilisateurDto accuse_reception;
    private UtilisateurDto responsables_gestion_diffusion;



}
