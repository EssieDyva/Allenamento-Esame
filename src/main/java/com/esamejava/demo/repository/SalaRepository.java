package com.esamejava.demo.repository;

import com.esamejava.demo.constanz.DBConfig;
import com.esamejava.demo.models.Sala;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaRepository {
    public static List<Sala> getAllSala() throws SQLException {
        List<Sala> salaList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement comando = null;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "SELECT * FROM sala";
            comando = conn.prepareStatement(query);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala(
                        rs.getLong("id"),
                        rs.getLong("cliente_id"),
                        rs.getLong("sala_id"),
                        rs.getInt("numero_posti"),
                        rs.getString("data_sala"),
                        rs.getDouble("totale"),
                        rs.getString("stato"));
                salaList.add(sala);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            if (comando != null)
                comando.close();
        }
        return salaList;
    }// end function

    public static Sala addFilm(Sala sala) throws SQLException {
        Connection conn = null;
        PreparedStatement comando = null;
        int righeInserite = 0;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "INSERT INTO PRENOTAZIONE (FILM_ID, SALA_ID, DATA_ORA, PREZZO BIGLIETTO, POSTI_DISPONIBILI) " +
                    "VALUES (?, ?, ?, ?, )";
            comando = conn.prepareStatement(query);
            comando.setLong(1, sala.getCliente_id());
            comando.setLong(2, sala.getProiezione_id());
            comando.setInt(3, sala.getNumero_posti());
            comando.setString(4, sala.getData_prenotazione());
            comando.setDouble(5, sala.getTotale());
            comando.setString(5, sala.getStato());
            righeInserite = comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
            if (comando != null)
                comando.close();
        }
        return righeInserite > 0 ? sala : null; // Return the added book or null if insertion failed
    }
}