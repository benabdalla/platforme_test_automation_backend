package com.saphir.platforme.controllors;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.ParametrageDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.IActionRepository;
import com.saphir.platforme.repository.IParametreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/v3/paremetrage")
public class ParametrageController {

    @Autowired
    IParametreRepository iParametreRepository;


    @PostMapping()
    @ResponseBody
    public ParametrageDto addParametrage(@RequestBody ParametrageDto parametrageDto) throws Exception {

        return iParametreRepository.addParametrage(parametrageDto);
    }

    @GetMapping()

    public List<ParametrageDto> addParametrage() throws Exception {

        return iParametreRepository.getAllParametrage();
    }


}
