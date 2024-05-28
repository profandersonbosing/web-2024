package br.unipar.springrest.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 10, max = 256)
    private String rua;

    @NotNull
    @NotBlank
    @NotEmpty
    private int numero;

    @ManyToOne
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 10, max = 256) String getRua() {
        return rua;
    }

    public void setRua(@NotNull @NotBlank @NotEmpty @Length(min = 10, max = 256) String rua) {
        this.rua = rua;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    public int getNumero() {
        return numero;
    }

    public void setNumero(@NotNull @NotBlank @NotEmpty int numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
