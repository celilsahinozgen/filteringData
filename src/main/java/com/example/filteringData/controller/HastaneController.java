package com.example.filteringData.controller;


import com.example.filteringData.dto.HastaneRequestDTO;
import com.example.filteringData.dto.HastaneSaveDTO;
import com.example.filteringData.service.HastaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/hastane")
public class HastaneController {

    private final HastaneService hastaneService;

    public HastaneController(HastaneService hastaneService) {
        this.hastaneService = hastaneService;
    }


    @GetMapping(name = "/findAll")
    public ResponseEntity<List<HastaneRequestDTO>> findAllHastane(){
        List<HastaneRequestDTO> listHastane = hastaneService.findAllHastane();
        return ResponseEntity.ok(listHastane);
    }

    @PostMapping(name = "/save")
    public ResponseEntity<HastaneSaveDTO> saveHastane(@RequestBody HastaneSaveDTO newHastane){
        HastaneSaveDTO newCreateHastane = hastaneService.saveHastane(newHastane);
        return ResponseEntity.ok(newCreateHastane);
    }
}
