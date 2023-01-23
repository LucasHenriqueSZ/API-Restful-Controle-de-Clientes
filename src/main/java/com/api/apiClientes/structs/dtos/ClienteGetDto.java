package com.api.apiClientes.structs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteGetDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("dataCadastro")
    private String dataCadastro;

    @JsonProperty("contato")
    private ContatoDto contato;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ContatoDto getContato() {
        return contato;
    }

    public void setContato(ContatoDto contato) {
        this.contato = contato;
    }

    

}
