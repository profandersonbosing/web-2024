/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.exemplo.rest.repositories;

import br.unipar.exemplo.rest.infraestructure.ConnectionFactory;
import br.unipar.exemplo.rest.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author andersonbosing
 */
public class ClienteRepository {
    
    private static final String INSERT = 
            "INSERT INTO CLIENTE(NOME, CPF) VALUES(?, ?)";
    
    public Cliente insert(Cliente cliente) throws SQLException, NamingException {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            connection = new ConnectionFactory().getConnection();

            pstmt = connection.prepareStatement(
                    INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
            
            rs.next();
            cliente.setId(rs.getInt(1));
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
            if (connection != null)
                connection.close();
        }
        
        return cliente;
        
    } 
    
}
