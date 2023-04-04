package com.saphir.platforme.service;

import com.saphir.platforme.dto.ConnexionDTO;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.UtilisateurQualipro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthentificationQualipro {
    @Autowired
    ActionService actionService;
    @Autowired
    UtilisateurService utilisateurService;
    List<Action> actionList;

    public List<UtilisateurQualipro> connextionParModule(String module, String respo, int row) {
        String name = null;
        if (module.equals("Action")) {
            actionList = actionService.getAllAction();
            switch (respo) {
                case "declencheur":
                    name = actionList.get(row).getDechlencheur();
                    break;
                case "RespoReal":
                    name = actionList.get(row).getRespSuivi();
                    break;
                case "Respoclot":
                    name = actionList.get(row).getResptraitement();
                    break;
                case "RespoSuivi":
                    name = actionList.get(row).getRespcloture();
                    break;
                default:
                    System.out.println("Invalid day: " + respo);
                    break;
            }
            ;

        }

        return utilisateurService.getLoginPaswword(name);
    }

}
