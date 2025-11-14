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
    private Long cliente_id;
    private Long proiezione_id;
    private Integer numero_posti;
    private String data_prenotazione;
    private Double totale;
    private String stato;

}
