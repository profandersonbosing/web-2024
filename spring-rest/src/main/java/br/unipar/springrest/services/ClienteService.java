package br.unipar.springrest.services;

import br.unipar.springrest.domain.Cliente;
import br.unipar.springrest.exceptions.ApiException;
import br.unipar.springrest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente) throws ApiException {
        validarAtributos(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }
    public Cliente update(Cliente cliente) throws ApiException {
        validarAtributos(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(Long id) throws ApiException {
        clienteRepository.deleteById(id);
    }

    private void validarAtributos(Cliente cliente) throws ApiException {
        if (cliente.getNome() == null) {
            throw new ApiException("O nome é Obrigatório");
        }

        if (cliente.getNome().length() > 60) {
            throw new ApiException("O tamanho do nome deve " +
                    "ser menor do que 60 caracteres");
        }

        if (cliente.getNome().length() < 10) {
            throw new ApiException("O tamanho do nome deve ser " +
                    "maior do que 10 caracteres");
        }

        if (cliente.getNome().isEmpty()) {
            throw new ApiException("O nome é obrigatório");
        }

        //Demais validações

    }

}
