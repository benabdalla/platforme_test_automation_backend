package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ScenarioDirectionDto {


    private long idScenarioDirection;
    private String filialeDeclencheur;
    private DirectionDto direction;
    private UtilisateurDto dechlencheur;

}
