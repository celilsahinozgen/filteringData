package com.example.filteringData.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hastane")
@Data
public class Hastane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "adres")
    private String adres;

}

