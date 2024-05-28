package br.unipar.springrest.controllers;

import br.unipar.springrest.domain.Cliente;
import br.unipar.springrest.exceptions.ApiException;
import br.unipar.springrest.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        //ResponseEntity - Manipula elemtento da Resposta
        // Analogo ao Response do JAX-RS
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Cliente>> findByEstado(@RequestParam("estado") String estado) {
        return ResponseEntity.ok(clienteService.findByEstadoNome(estado));
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody @Valid Cliente cliente,
                                          UriComponentsBuilder builder) {

        clienteService.insert(cliente);

        URI uri =
                builder.path("/cliente/{id}").
                        buildAndExpand(cliente.getId()).toUri();

        //URI uri = ServletUriComponentsBuilder.
        // fromCurrentRequest().path("/{id}").
        // buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(cliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id,
                                          @RequestBody Cliente cliente) {
        clienteService.update(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}