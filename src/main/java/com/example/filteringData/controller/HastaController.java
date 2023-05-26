package com.example.filteringData.controller;



import com.example.filteringData.dto.HastaRequestDTO;
import com.example.filteringData.dto.HastaSaveDTO;
import com.example.filteringData.service.HastaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/hasta")
public class HastaController {

    private final HastaService hastaService;

    public HastaController(HastaService hastaService) {
        this.hastaService = hastaService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<HastaRequestDTO>> findAllHasta(){
        List<HastaRequestDTO> listHasta = hastaService.findAllHasta();
        return ResponseEntity.ok(listHasta);
    }
    @GetMapping("/findBy/{id}")
    public ResponseEntity<HastaRequestDTO> findByHasta(@PathVariable Long id){
        HastaRequestDTO findby = hastaService.FindByHasta(id);
        return ResponseEntity.ok(findby);
    }
    @PostMapping("/save")
    public ResponseEntity<HastaSaveDTO> save(@RequestBody HastaSaveDTO newHastaDto){
        HastaSaveDTO newHasta = hastaService.save(newHastaDto);
        return ResponseEntity.ok(newHasta);
    }

}
