package com.example.filteringData.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "muayene_yeri")
@Data
public class MuayeneYeri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "adres")
    private String adres;

    @ManyToOne
    @JoinColumn(name = "hastane_id")
    private Hastane hastane;

}