package com.example.filteringData.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilterRequestDTO {


    private Long tckNo;

    private String name;

    private String lastname;

    private Integer age;

    private String il;

    private String ilce;

    private String acikAdres;

    private LocalDateTime createDate;

    private LocalDateTime updateDate = LocalDateTime.now();
}
