package com.esamejava.demo.repository;

import com.esamejava.demo.constanz.DBConfig;
import com.esamejava.demo.models.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmRepository {
    public static List<Film> getAllFilm() throws SQLException {
        List<Film> filmList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement comando = null;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "SELECT * FROM film";
            comando = conn.prepareStatement(query);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Film film = new Film(
                        rs.getLong("id"),
                        rs.getString("titolo"),
                        rs.getString("regista"),
                        rs.getInt("durataMinuti"),
                        rs.getString("genere"),
                        rs.getInt("annoUscita"));
                filmList.add(film);
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
        return filmList;
    }// end function

    public static Film addFilm(Film film) throws SQLException {
        Connection conn = null;
        PreparedStatement comando = null;
        int righeInserite = 0;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "INSERT INTO FILM (TITOLO, REGISTA, DURATAMINUTI, GENERE, ANNOUSCITA) " +
                    "VALUES (?, ?, ?, ?, ?, )";
            comando = conn.prepareStatement(query);
            comando.setString(1, film.getTitolo());
            comando.setString(2, film.getRegista());
            comando.setInt(3, film.getDurataMinuti());
            comando.setString(4, film.getGenere());
            comando.setInt(5, film.getAnnoUscita());
            righeInserite = comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
                conn.close();
            if(comando != null)
                comando.close();
        }
        return righeInserite > 0 ? film : null; // Return the added book or null if insertion failed
    }
}