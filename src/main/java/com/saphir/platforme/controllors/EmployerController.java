package com.saphir.platforme.controllors;

import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/v1/employees")
public class EmployerController {
    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping()
    public List<Utilisateur> getAllEmploye() throws Exception {
        return utilisateurService.getAllUser();
    }
//
//    @GetMapping("/{id}")
//    public List<UtilisateurQualipro> getAllEmploye(@PathVariable Long id) throws Exception {
//        return utilisateurService.getAllUser();
//    }
//    @PostMapping()
//    public List<UtilisateurQualipro> getAllEmploye(@RequestBody Long throws Exception {
//        return utilisateurService.getAllUser();
//    }

}



