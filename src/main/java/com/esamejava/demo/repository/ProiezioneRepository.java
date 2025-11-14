package com.esamejava.demo.repository;

import com.esamejava.demo.constanz.DBConfig;
import com.esamejava.demo.models.Proiezione;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProiezioneRepository {
    public static List<Proiezione> getAllPrenotazione() throws SQLException {
        List<Proiezione> proiezioneList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement comando = null;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "SELECT * FROM proiezione";
            comando = conn.prepareStatement(query);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Proiezione proiezione = new Proiezione(
                        rs.getLong("id"),
                        rs.getLong("cliente_id"),
                        rs.getLong("proiezione_id"),
                        rs.getInt("numero_posti"),
                        rs.getString("data_proiezione"),
                        rs.getDouble("totale"),
                        rs.getString("stato"));
                proiezioneList.add(proiezione);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            if (comando != null)
                comando.close();
        }
        return proiezioneList;
    }// end function

    public static Proiezione addFilm(Proiezione proiezione) throws SQLException {
        Connection conn = null;
        PreparedStatement comando = null;
        int righeInserite = 0;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "INSERT INTO PRENOTAZIONE (FILM_ID, SALA_ID, DATA_ORA, PREZZO BIGLIETTO, POSTI_DISPONIBILI) " +
                    "VALUES (?, ?, ?, ?, )";
            comando = conn.prepareStatement(query);
            comando.setLong(1, proiezione.getCliente_id());
            comando.setLong(2, proiezione.getProiezione_id());
            comando.setInt(3, proiezione.getNumero_posti());
            comando.setString(4, proiezione.getData_prenotazione());
            comando.setDouble(5, proiezione.getTotale());
            comando.setString(5, proiezione.getStato());
            righeInserite = comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            if (comando != null)
                comando.close();
        }
        return righeInserite > 0 ? proiezione : null; // Return the added book or null if insertion failed
    }
}
