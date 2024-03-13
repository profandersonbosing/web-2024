/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws.repositories;

import br.unipar.livraria.ws.infraestructure.ConnectionFactory;
import br.unipar.livraria.ws.model.Livro;
import br.unipar.livraria.ws.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author andersonbosing
 */
public class LivroRepository {
    
    public LivroRepository() {
    }
    
    public ArrayList<Livro> findLivro(String nome) {
        return null;
    }
    
    public ArrayList<Livro> listAll(){
        return null;
    }
    
    public Livro findById(int id){
        return null;
    }

    public Livro insert(Livro livro) throws SQLException {
        
        String query = 
                "INSERT INTO LIVRO (NOME, DT_LANCTO, NR_PAGINAS, "
                + "ID_EDITORA, ID_AUTOR) "
                + "VALUES(?, ?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(query, 
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, livro.getNome());
            ps.setDate(2, new java.sql.Date(livro.getDtLancto().getTime()));
            ps.setInt(3, livro.getNrPaginas());
            ps.setInt(4, livro.getEditora().getId());
            ps.setInt(5, livro.getAutor().getId());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            livro.setId(rs.getInt(1));
            
            //conn.commit();
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return livro;
    }
    
}
