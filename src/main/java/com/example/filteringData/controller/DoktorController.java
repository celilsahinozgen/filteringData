package com.example.filteringData.controller;



import com.example.filteringData.dto.DoktorRequestDTO;
import com.example.filteringData.dto.DoktorSaveDTO;
import com.example.filteringData.dto.DoktorUpdateDTO;
import com.example.filteringData.service.DoktorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api1/doktor")

public class DoktorController {

    private final DoktorService doktorService;


    @GetMapping("/findAll")
    public ResponseEntity<List<DoktorRequestDTO>> AllDoktor(){
        List<DoktorRequestDTO> listDoktor = doktorService.AllDoktor();
        return ResponseEntity.ok(listDoktor);
    }

    @GetMapping("/finBy/{id}")
    public ResponseEntity<DoktorRequestDTO> findByDoktor(@PathVariable Long id){
        DoktorRequestDTO findByDoktor = doktorService.findByDoktor(id);
        return ResponseEntity.ok(findByDoktor);
    }

    @PostMapping("/save")
    public ResponseEntity<DoktorSaveDTO> saveDoktor(@RequestBody DoktorSaveDTO newDoktor){
        DoktorSaveDTO saveNewDoktor = doktorService.saveDoktor(newDoktor);
        return ResponseEntity.ok(saveNewDoktor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoktorUpdateDTO> updateDoktor(@PathVariable Long id, @RequestBody DoktorUpdateDTO updateDoktor){
        DoktorUpdateDTO UpdateNewDoktor = doktorService.updateDoktor(id,updateDoktor);
        return ResponseEntity.ok(UpdateNewDoktor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteDoktor (@PathVariable Long id) {
        Boolean status = doktorService.deleteDoktor(id);
        return ResponseEntity.ok(status);
    }


}
