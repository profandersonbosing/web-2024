/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws;

import br.unipar.livraria.ws.interfaces.LivrariaWebService;
import br.unipar.livraria.ws.model.Livro;
import br.unipar.livraria.ws.services.LivroService;
import jakarta.jws.WebService;
import java.util.ArrayList;


/**
 *
 * @author andersonbosing
 */
//SIB: Service Implementation Bean
@WebService(endpointInterface = "br.unipar.livraria.ws.interfaces.LivrariaWebService")
public class LivrariaWebServiceImp implements LivrariaWebService {

    @Override
    public ArrayList<Livro> findLivro(String nome) {
        LivroService livrariaService = new LivroService();
        return livrariaService.findLivro(nome);
    }

    @Override
    public ArrayList<Livro> listAll() {
        LivroService livrariaService = new LivroService();
        return livrariaService.listAll();
    }

    @Override
    public Livro findById(int id) {
        LivroService livrariaService = new LivroService();
        return livrariaService.findById(id);
    }

    @Override
    public String logar(String login, String senha) {
        
        if (login.equals("admin") && senha.equals("admin"))
            return "Usuário Logado";
        
        return "Usuário ou senha Incorretos!";
    
    }

    @Override
    public Livro inserir(Livro livro) {
        LivroService livroService = new LivroService();
        return livroService.insert(livro);
    }

    @Override
    public Livro atualizar(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
