/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.livraria.ws.interfaces;

import br.unipar.livraria.ws.model.Livro;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author andersonbosing
 */
//SEI: Interface Endpoint Service
@WebService
public interface LivrariaWebService {
    
    @WebMethod
    ArrayList<Livro> findLivro(String nome);
    
    @WebMethod
    ArrayList<Livro> listAll();
    
    @WebMethod
    Livro findById(@WebParam int id);
    
    @WebMethod
    String logar(@WebParam(header = true) String login, 
                 @WebParam(header = true) String senha);
    
    @WebMethod
    Livro inserir(Livro livro);
    
    @WebMethod
    Livro atualizar(Livro livro);
    
    @WebMethod
    void deletar(int id);
    
}
