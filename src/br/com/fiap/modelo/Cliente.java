/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.modelo;

import java.sql.Date;

/**
 *
 * @author rm74632
 */
public class Cliente {
    private String nome;
    private String endereco;
    private Date nascimento;
    private String fone;
    private String caminho;

    public Cliente(String nome, String endereco, Date nascimento, String fone, String caminho) {
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.fone = fone;
        this.caminho = caminho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
}
