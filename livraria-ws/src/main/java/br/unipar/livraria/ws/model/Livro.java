/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws.model;

import java.util.Date;




/**
 *
 * @author andersonbosing
 */
public class Livro {
    
    
    private int id;
    private String nome;
    private Date dtLancto;
    private int nrPaginas;
    private Pessoa editora;
    private Pessoa autor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtLancto() {
        return dtLancto;
    }

    public void setDtLancto(Date dtLancto) {
        this.dtLancto = dtLancto;
    }

    public int getNrPaginas() {
        return nrPaginas;
    }

    public void setNrPaginas(int nrPaginas) {
        this.nrPaginas = nrPaginas;
    }

    public Pessoa getEditora() {
        return editora;
    }

    public void setEditora(Pessoa editora) {
        this.editora = editora;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", nome=" + nome + ", dtLancto=" + dtLancto + ", nrPaginas=" + nrPaginas + ", editora=" + editora + ", autor=" + autor + '}';
    }
    
    
    
}
