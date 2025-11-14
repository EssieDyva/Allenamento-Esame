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
public class Prenotazione implements Serializable {
    private Long id;
    private Long film_id;
    private Long sala_id;
    private String data_ora;
    private Double prezzo_biglietto;
    private Integer posti_disponibili;
}
