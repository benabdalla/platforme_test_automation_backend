package com.saphir.platforme.service;

import com.saphir.platforme.entity.Parametrage;
import com.saphir.platforme.repository.ParametreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrageService {
    @Autowired
    ParametreRepository parametreRepository;

    public List<Parametrage> getAllParametere() {
        return parametreRepository.findAll();
    }
}
