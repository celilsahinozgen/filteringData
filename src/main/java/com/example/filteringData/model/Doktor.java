package com.example.filteringData.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "doktor")
@Data
public class Doktor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @ManyToOne
    @JoinColumn(name = "hastane_id")
    private Hastane hastane;



}
