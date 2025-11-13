package com.esamejava.demo.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Film implements Serializable {
    private String nomeFilm;
    private Long id;
    private String titolo;
    private String regista;
    private Integer durataMinuti;
    private String genere;
    private Integer annoUscita;
}

