package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ScenarioServiceDto {


    private long idScenarioService;
    private String filialeDeclencheur;
    private TabServiceDto tabService;
    private UtilisateurDto dechlencheur;
}
