package br.unipar.springrest.controllers;

import br.unipar.springrest.domain.Cliente;
import br.unipar.springrest.exceptions.ApiException;
import br.unipar.springrest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente,
                                          UriComponentsBuilder builder)
            throws ApiException {

        clienteService.insert(cliente);

        URI uri =
                builder.path("/cliente/{id}").
                        buildAndExpand(cliente.getId()).toUri();

        //URI uri = ServletUriComponentsBuilder.
        // fromCurrentRequest().path("/{id}").
        // buildAndExpand(category.getId()).toUri();

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