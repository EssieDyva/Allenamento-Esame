package com.esamejava.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente implements Serializable {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;

}
