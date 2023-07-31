package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ScenarioActiviteDto {


    private long idScenarioActivite;
    private String filialeDeclencheur;
    private ActiviteDto activite;
    private UtilisateurDto dechlencheur;
}
