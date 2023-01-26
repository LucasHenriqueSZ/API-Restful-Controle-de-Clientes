package com.api.apiClientes.structs;

import java.util.List;

import com.api.apiClientes.model.Cliente;
import com.api.apiClientes.model.Contato;
import com.api.apiClientes.structs.dtos.ClienteGetDto;
import com.api.apiClientes.structs.dtos.ClientePostDto;
import com.api.apiClientes.structs.dtos.ContatoDto;

public interface StructsMappers {

    // retorna um cliente a partir de um clientePostDto
    Cliente clientePostDtoToCliente(ClientePostDto clientePostDto);

    //retorna um ClienteGetDto apartir de um cliente
    ClienteGetDto clienteToClienteGetDto(Cliente cliente);

    //retorna um contatoDto apartir de um contato
    ContatoDto contatoToContatoDto(Contato contato);

    // retorna um contato a partir de um contatoPostDto
    Contato contatoDtoToContato(ContatoDto contatoPostDto);

    //recebe uma lista de clientes e retorna uma lista de clientesGetDto
    List<ClienteGetDto> listClientesToListClientesGetDto(List<Cliente> clientes);

}
