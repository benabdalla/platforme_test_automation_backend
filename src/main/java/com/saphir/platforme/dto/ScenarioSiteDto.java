package com.saphir.platforme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saphir.platforme.entity.Site;
import com.saphir.platforme.entity.Utilisateur;
import lombok.*;

import javax.persistence.*;
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
