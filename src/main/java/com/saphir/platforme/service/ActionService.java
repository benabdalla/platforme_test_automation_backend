package com.saphir.platforme.service;

import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionService {
    @Autowired
    ActionRepository actionRepository;
    public List<Action> getAllAction(){
      return actionRepository.findAll();
    }

}
