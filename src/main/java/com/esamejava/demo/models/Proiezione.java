package com.esamejava.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proiezione implements Serializable{
    private Long id;
    private Long cliente_id;
    private Long proiezione_id;
    private Integer numero_posti;
    private LocalDateTime data_prenotazione;
    private BigDecimal totale;
    private String stato;

}
