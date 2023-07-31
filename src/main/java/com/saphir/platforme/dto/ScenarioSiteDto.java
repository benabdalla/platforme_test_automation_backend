package com.saphir.platforme.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ScenarioSiteDto {
    private long idScenarioSite;
    private String filialeDeclencheur;
    private SiteDto site;
    private UtilisateurDto dechlencheur;

}
