package com.api.apiClientes.structs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.validation.constraints.Size;

public class ContatoDto {

    @JsonProperty("tipo")
    @Size(min = 5)
    private String tipo;

    @JsonProperty("texto")
       private String texto;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
