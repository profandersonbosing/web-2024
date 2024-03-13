/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws.services;

import br.unipar.livraria.ws.model.Livro;
import br.unipar.livraria.ws.repositories.LivroRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andersonbosing
 */
public class LivroService {
    
    public ArrayList<Livro> listAll() {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.listAll();
    }
    
    public ArrayList<Livro> findLivro(String nome) {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.findLivro(nome);
    }
   
    public Livro findById(int id){
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.findById(id);
    }
    
    public Livro insert(Livro livro) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.insert(livro);
    }
    
}
