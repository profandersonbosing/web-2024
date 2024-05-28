package br.unipar.springrest.repositories;

import br.unipar.springrest.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query
    public List<Cliente> findByCpfContaining(String cpf);

    @Query
    public List<Cliente> findByEnderecoCidadeEstadoNome(String nome);

}
