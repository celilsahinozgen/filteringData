package com.example.filteringData.controller;


import com.example.filteringData.dto.FilterRequestDTO;
import com.example.filteringData.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("filter")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/datafilter")
    public ResponseEntity<List<FilterRequestDTO>> filterDataFilter(
            @RequestParam(name = "createDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime createDate,
            @RequestParam(name = "startcreateDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime startcreateDate,
            @RequestParam(name = "endcreateDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime endcreateDate,
            @RequestParam(name = "name", required = false) String name,
    @RequestParam(name = "age", required = false) Integer age,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "100") int size)

    {
    List<FilterRequestDTO> filterRequestDTOS = filterService.filterData(createDate,startcreateDate,endcreateDate,name,age,page,size);
    return ResponseEntity.ok(filterRequestDTOS);


    }
}
