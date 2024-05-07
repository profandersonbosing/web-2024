/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.exemplo.rest.services;

import br.unipar.exemplo.rest.exceptions.ValidacaoException;
import br.unipar.exemplo.rest.models.Cliente;
import br.unipar.exemplo.rest.repositories.ClienteRepository;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author andersonbosing
 */
public class ClienteService {
   
    public Cliente insert(Cliente cliente) throws 
            ValidacaoException, 
            SQLException, 
            NamingException {
        
        if (cliente.getCpf().isEmpty())
            throw new ValidacaoException("Cpf não pode ser vazio");
        
        if (cliente.getCpf().trim().length() != 11)
            throw new ValidacaoException("Valor de Cpf informado invalido");
        
        if (cliente.getNome().trim().isEmpty())
            throw new ValidacaoException("Nome não pode ser vazio");
        
        return new ClienteRepository().insert(cliente);
        
    }
    
}
