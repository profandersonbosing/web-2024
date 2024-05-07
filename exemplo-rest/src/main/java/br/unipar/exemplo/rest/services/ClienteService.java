/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.exemplo.rest.services;

import br.unipar.exemplo.rest.exceptions.ValidacaoException;
import br.unipar.exemplo.rest.models.Cliente;
import br.unipar.exemplo.rest.repositories.ClienteRepository;
import java.sql.SQLException;
import java.util.List;
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
        
        validateInsertOrUpdate(cliente);
        
        return new ClienteRepository().insert(cliente);
        
    }
    
    public Cliente update(Cliente cliente) throws 
            ValidacaoException, 
            SQLException, 
            NamingException {
        
        validateInsertOrUpdate(cliente);
        
        return new ClienteRepository().update(cliente);
        
    }
    
    public void delete(int id) throws 
            ValidacaoException, 
            SQLException, 
            NamingException {
        
        if (id == 0) 
            throw new ValidacaoException("Informe o Cliente a ser Deletado");
        
        new ClienteRepository().delete(id);
        
    }
    
    public List<Cliente> findAll() throws 
            SQLException, 
            NamingException {
        
        return new ClienteRepository().findAll();
        
    }
    
    public Cliente findById(int id) throws 
            SQLException, 
            NamingException {
        
        return new ClienteRepository().findById(id);
        
    }
    
    private void validateInsertOrUpdate(Cliente cliente) throws ValidacaoException {
        
        if (cliente.getCpf().isEmpty())
            throw new ValidacaoException("Cpf não pode ser vazio");
        
        if (cliente.getCpf().trim().length() != 11)
            throw new ValidacaoException("Valor de Cpf informado invalido");
        
        if (cliente.getNome().trim().isEmpty())
            throw new ValidacaoException("Nome não pode ser vazio");
    }
    
}
