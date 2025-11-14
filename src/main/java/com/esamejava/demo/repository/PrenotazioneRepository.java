package com.esamejava.demo.repository;

import com.esamejava.demo.constanz.DBConfig;
import com.esamejava.demo.models.Prenotazione;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneRepository {
    public static List<Prenotazione> getAllPrenotazione() throws SQLException {
        List<Prenotazione> prenotazioneList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement comando = null;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "SELECT * FROM prenotazione";
            comando = conn.prepareStatement(query);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Prenotazione prenotazione = new Prenotazione(
                        rs.getLong("id"),
                        rs.getLong("film_id"),
                        rs.getLong("sala_id"),
                        rs.getString("data_ora"),
                        rs.getDouble("prezzo_biglietto"),
                        rs.getInt("posti_disponibili"));
                prenotazioneList.add(prenotazione);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(conn != null)
                conn.close();
            if(comando != null)
                comando.close();
        }
        return prenotazioneList;
    }// end function

    public static Prenotazione addFilm(Prenotazione prenotazione) throws SQLException {
        Connection conn = null;
        PreparedStatement comando = null;
        int righeInserite = 0;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "INSERT INTO PRENOTAZIONE (FILM_ID, SALA_ID, DATA_ORA, PREZZO BIGLIETTO, POSTI_DISPONIBILI) " +
                    "VALUES (?, ?, ?, ?, )";
            comando = conn.prepareStatement(query);
            comando.setLong(1, prenotazione.getFilm_id());
            comando.setLong(2, prenotazione.getSala_id());
            comando.setString(3, prenotazione.getData_ora());
            comando.setDouble(4, prenotazione.getPrezzo_biglietto());
            comando.setInt(5, prenotazione.getPosti_disponibili());
            righeInserite = comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
                conn.close();
            if(comando != null)
                comando.close();
        }
        return righeInserite > 0 ? prenotazione : null; // Return the added book or null if insertion failed
    }
}