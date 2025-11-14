package com.esamejava.demo.repository;

import com.esamejava.demo.constanz.DBConfig;
import com.esamejava.demo.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    public static List<Cliente> getAllCliente() throws SQLException {
        List<Cliente> clienteList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement comando = null;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "SELECT * FROM cliente";
            comando = conn.prepareStatement(query);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("telefono"));
                clienteList.add(cliente);
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
        return clienteList;
    }// end function

    public static Cliente addFilm(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement comando = null;
        int righeInserite = 0;
        try {
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PPW);
            String query = "INSERT INTO CLIENTE (NOME, COGNOME, EMAIL, TELEFONO) " +
                    "VALUES (?, ?, ?, ?, )";
            comando = conn.prepareStatement(query);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCognome());
            comando.setString(3, cliente.getEmail());
            comando.setString(4, cliente.getTelefono());
            righeInserite = comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(conn != null)
                conn.close();
            if(comando != null)
                comando.close();
        }
        return righeInserite > 0 ? cliente : null; // Return the added book or null if insertion failed
    }
}