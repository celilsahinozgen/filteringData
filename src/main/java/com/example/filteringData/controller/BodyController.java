package com.example.filteringData.controller;

import com.example.filteringData.dto.ArabaMarkalariDTO;
import com.example.filteringData.dto.FilterRequestDTO;
import com.example.filteringData.service.ArabaMarkalariService;
import com.example.filteringData.service.BodyFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BodyController {
    private final BodyFilterService bodyFilterService;


    @PostMapping("/filter")
    public ResponseEntity<List<FilterRequestDTO>> filterArabaMarkalari(@RequestBody FilterRequestDTO filterParameters) {
        List<FilterRequestDTO> filterRequestDTOList = bodyFilterService.filterArabaMarkalar(
                filterParameters.getTckNo(), filterParameters.getName(),
                filterParameters.getName(), filterParameters.getAge(),
                filterParameters.getIl(), filterParameters.getIlce(),
                  filterParameters.getLastname(),filterParameters.getCreateDate(),filterParameters.getUpdateDate());

        return ResponseEntity.ok(filterRequestDTOList);
    }
}