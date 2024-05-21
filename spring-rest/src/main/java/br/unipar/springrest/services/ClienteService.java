package br.unipar.springrest.services;

import br.unipar.springrest.domain.Cliente;
import br.unipar.springrest.exceptions.ApiException;
import br.unipar.springrest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente insert(Cliente cliente) throws ApiException {
        validate(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }
    private void validate(Cliente cliente) throws ApiException {
        if (cliente.getNome() == null ){
            throw new ApiException("Nome é obrigatório");
        }
        if (cliente.getNome().isEmpty()) {
            throw new ApiException("Nome é obrigatório");
        }
        if (cliente.getNome().length() > 60){
            throw new ApiException("Nome deve ter no máximo 60 caracteres");
        }
        if (cliente.getNome().length() < 30){
            throw new ApiException("Nome deve ter no mínimo 30 caracteres");
        }

    }
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
