package com.esamejava.demo.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sala implements Serializable {
    private Long id;
    private String nome;
    private Integer capienza;
    private String tipoSala;
}
