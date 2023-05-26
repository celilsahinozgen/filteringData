package com.example.filteringData.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "hasta")
@Entity
public class Hasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "adres")
    private String tcNo;
}

