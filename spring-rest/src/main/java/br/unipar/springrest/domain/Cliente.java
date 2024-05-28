package br.unipar.springrest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 10, max = 256)
    private String nome;

    @CPF
    private String cpf;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 7, max = 10)
    private String telefone;

    @ManyToOne
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 10, max = 256) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank @NotEmpty @Length(min = 10, max = 256) String nome) {
        this.nome = nome;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 7, max = 10) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank @NotEmpty @Length(min = 7, max = 10) String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
