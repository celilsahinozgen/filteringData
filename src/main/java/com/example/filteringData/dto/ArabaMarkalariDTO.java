package com.example.filteringData.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class ArabaMarkalariDTO {


    private LocalDateTime dogumTarihi;


    private LocalDateTime olumTarihi;


    private String  ulke;


    private String  name;


    private String  lastname;
}
