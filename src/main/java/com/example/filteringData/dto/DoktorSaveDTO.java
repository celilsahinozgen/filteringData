package com.example.filteringData.dto;


import com.example.filteringData.model.Hastane;
import lombok.Data;



@Data
public class DoktorSaveDTO {


    private String ad;

    private String soyad;

    private Hastane hastane;
}
