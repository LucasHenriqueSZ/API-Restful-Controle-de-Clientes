package com.api.apiClientes.structs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientePostDto {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("contato")
    private ContatoDto contato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContatoDto getContato() {
        return contato;
    }

    public void setContato(ContatoDto contato) {
        this.contato = contato;
    }

}
