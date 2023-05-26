package com.example.filteringData.model;


import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Filter")
@Data
public class Filter {

    public static final String ZAMANPATTERIN= "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "TCKNO")
    private Long tckNo;

    @Column(name = "ISIM")
    private String name;

    @Column(name = "SOYISIM")
    private String lastname;

    @Column(name = "YAS")
    private Integer age;

    @Column(name = "IL")
    private String il;

    @Column(name = "ILCE")
    private String ilce;

    @Column(name = "ACIKADRES")
    private String acikAdres;

    @Column(name = "OLUSDURMATARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime createDate;

    @Column(name = "GUNCELLEMETARIHI")
    @DateTimeFormat(pattern = ZAMANPATTERIN)
    private LocalDateTime updateDate;



}
