package br.unipar.springrest.controllers;

import br.unipar.springrest.domain.Cliente;
import br.unipar.springrest.exceptions.ApiException;
import br.unipar.springrest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        return "Cliente com id " + id;
    }
    @GetMapping("/all")
    public String getAll() {
        return "Todos os clientes";
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente)
            throws ApiException {
        return clienteService.insert(cliente);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id) {
        return "Cliente com id " + id + " atualizado";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return "Cliente com id " + id + " deletado";
    }
}
