package com.saphir.platforme.service;

import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceAction {
    @Autowired
    ActionRepository actionRepository;
    public List<Action> getAllAction(){
      return actionRepository.findAll();
    }

}
