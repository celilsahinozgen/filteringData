package com.example.filteringData.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Akraba")
@Data
public class Akraba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    @Column(name = "dogumtarihi")
    private String dogumTarihi;


}
