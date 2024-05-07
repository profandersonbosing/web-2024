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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author andersonbosing
 */
public class ClienteRepository {
    
    private static final String INSERT = 
            "INSERT INTO CLIENTE(NOME, CPF) VALUES(?, ?)";
    
    private static final String FIND_ALL = 
            "SELECT ID, NOME, CPF FROM CLIENTE";
    
    private static final String FIND_BY_ID = 
            "SELECT ID, NOME, CPF FROM CLIENTE WHERE ID = ?";
    
    private static final String DELETE = 
            "DELETE FROM CLIENTE WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE CLIENTE SET NOME = ?, CPF = ? WHERE ID = ?";
    
    
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
    
    public List<Cliente> findAll() throws SQLException, NamingException {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Cliente> resultado = new ArrayList<>();
        
        try {
            
            connection = new ConnectionFactory().getConnection();

            pstmt = connection.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                resultado.add(
                        new Cliente(rs.getInt("ID"),
                            rs.getString("NOME"),
                            rs.getString("CPF"))
                );
            }
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
            if (connection != null)
                connection.close();
        }
        
        return resultado;
        
    }
    
    public Cliente findById(int id) throws SQLException, NamingException {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        
        try {
            
            connection = new ConnectionFactory().getConnection();

            pstmt = connection.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                c = new Cliente(rs.getInt("ID"),
                    rs.getString("NOME"),
                    rs.getString("CPF"));
            }
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
            if (connection != null)
                connection.close();
        }
        
        return c;
        
    }
    
    public void delete(int id) throws SQLException, NamingException {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            
            connection = new ConnectionFactory().getConnection();

            pstmt = connection.prepareStatement(DELETE);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (connection != null)
                connection.close();
        }
        
    }
    
    public Cliente update(Cliente cliente) throws SQLException, NamingException {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            
            connection = new ConnectionFactory().getConnection();

            pstmt = connection.prepareStatement(UPDATE);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setInt(3, cliente.getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (connection != null)
                connection.close();
        }
        
        return cliente;
        
    } 
    
}
