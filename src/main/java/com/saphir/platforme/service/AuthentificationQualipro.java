package com.saphir.platforme.service;

import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Utilisateur;
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

    public List<Utilisateur> connextionParModule(String module, String respo, int row) {
        String name = null;
        if (module.equals("Action")) {
            //  actionList = actionService.getAllAction();
            //                case "declencheur":
            //                    name = actionList.get(row).getDechlencheur();
            //                    break;
            //                case "RespoReal":
            //                    name = actionList.get(row).getRespSuivi();
            //                    break;
            ////                case "Respoclot":
            ////                    name = actionList.get(row).getResptraitement();
            ////                    break;
            //                case "RespoSuivi":
            //                    name = actionList.get(row).getRespcloture();
            //                    break;
            System.out.println("Invalid day: " + respo);

        }

        return utilisateurService.getLoginPaswword(name);
    }

}
