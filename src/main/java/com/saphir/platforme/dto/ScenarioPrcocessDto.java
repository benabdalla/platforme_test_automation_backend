package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class ScenarioPrcocessDto {

    private long idScenarioProcessus;
    private String filialeDeclencheur;
    private ProcessusDto processus;
    private UtilisateurDto dechlencheur;
}
