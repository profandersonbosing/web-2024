/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.livraria.ws.model;

/**
 *
 * @author andersonbosing
 */
public class Pessoa {
    
    private int id;
    private String nome;

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

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
