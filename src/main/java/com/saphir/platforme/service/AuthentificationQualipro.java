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



}
