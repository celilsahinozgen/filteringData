package com.example.filteringData.controller;


import com.example.filteringData.dto.ArabaMarkalariDTO;
import com.example.filteringData.service.ArabaMarkalariService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.filteringData.model.ArabaMarkalari.ZAMANPATTERIN;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arabamarkalari")
@CrossOrigin("*")
public class ArabaMarkalariController {


    private final ArabaMarkalariService arabaMarkalariService;

    @GetMapping("/filter")
    public ResponseEntity<List<ArabaMarkalariDTO>> filterArabaMarkalari(
            @RequestParam(name = "dogumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN) LocalDateTime dogumTarihi,
            @RequestParam(name = "startdogumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN)LocalDateTime startDogumTarihi,
            @RequestParam(name = "enddogumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN)LocalDateTime endDogumTarihi,
            @RequestParam(name = "olumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN) LocalDateTime olumTarihi,
            @RequestParam(name = "startstartOlumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN)LocalDateTime startOlumTarihi,
            @RequestParam(name = "endendOlumTarihi", required = false) @DateTimeFormat(pattern = ZAMANPATTERIN)LocalDateTime endOlumTarihi,
            @RequestParam(name = "ulke", required = false) String ulke,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "lastname", required = false) String lastname) {
        List<ArabaMarkalariDTO> arabaMarkalariDTOList = arabaMarkalariService.filterArabaMarkalar(dogumTarihi,startDogumTarihi
                ,endDogumTarihi,olumTarihi,startOlumTarihi,endOlumTarihi,ulke,name,lastname);
        return ResponseEntity.ok(arabaMarkalariDTOList);
    }







}
