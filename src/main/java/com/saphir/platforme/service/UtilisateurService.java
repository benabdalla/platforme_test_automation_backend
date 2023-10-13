package com.saphir.platforme.service;

import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.repository.UtilisateurQualiproRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurQualiproRepository utilisateurQualiproRepository;


    public Utilisateur getUser(String name) {

        return utilisateurQualiproRepository.findByName(name);
        //utilisateurQualiproRepository.findByName(name);

    }

    public List<Utilisateur> getAllUser() {
        List<Utilisateur> employees = new ArrayList<Utilisateur>();
        utilisateurQualiproRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
        //utilisateurQualiproRepository.findByName(name);

    }
}
