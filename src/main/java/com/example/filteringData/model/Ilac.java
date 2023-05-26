package com.example.filteringData.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ilac")
@Data
public class Ilac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "aciklama")
    private String aciklama;

}

