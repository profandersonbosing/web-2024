/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws.repositories;

import br.unipar.livraria.ws.model.Livro;
import br.unipar.livraria.ws.model.Pessoa;
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

    public Livro insert(Livro livro) {
        
        String query = 
                "INSERT INTO LIVRO (NOME, DT_LANCTO, NR_PAGINAS, "
                + "ID_EDITORA, ID_AUTOR) "
                + "VALUES(?, ?, ?, ?, ?);";
        
        
        
        return null;
    }
    
}
