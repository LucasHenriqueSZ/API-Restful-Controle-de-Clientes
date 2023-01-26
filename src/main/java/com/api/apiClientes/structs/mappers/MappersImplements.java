package com.api.apiClientes.structs.mappers;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.apiClientes.model.Cliente;
import com.api.apiClientes.model.Contato;
import com.api.apiClientes.structs.StructsMappers;
import com.api.apiClientes.structs.dtos.ClienteGetDto;
import com.api.apiClientes.structs.dtos.ClientePostDto;
import com.api.apiClientes.structs.dtos.ContatoDto;

@Component
public class MappersImplements implements StructsMappers {

    @Override
    public Cliente clientePostDtoToCliente(ClientePostDto clientePostDto) {
        if (clientePostDto == null) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNome(clientePostDto.getNome());
        cliente.setDataCadastro(new Date(System.currentTimeMillis()));

        return cliente;
    }

    @Override
    public ClienteGetDto clienteToClienteGetDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        ClienteGetDto ClienteGetDto = new ClienteGetDto();
        ClienteGetDto.setId(cliente.getId());
        ClienteGetDto.setNome(cliente.getNome());
        ClienteGetDto.setDataCadastro(cliente.getDataCadastro().toString());
        ClienteGetDto.setContato(contatoToContatoDto(cliente.getContato()));

        return ClienteGetDto;
    }

    @Override
    public ContatoDto contatoToContatoDto(Contato contato) {
        if (contato == null) {
            return null;
        }

        ContatoDto contatoDto = new ContatoDto();
        contatoDto.setTexto(contato.getTexto());
        contatoDto.setTipo(contato.getTipo());

        return contatoDto;
    }

    @Override
    public Contato contatoDtoToContato(ContatoDto contatoPostDto) {
        if (contatoPostDto == null) {
            return null;
        }

        Contato contato = new Contato();

        contato.setTipo(contatoPostDto.getTipo());
        contato.setTexto(contatoPostDto.getTexto());

        return contato;
    }

    @Override
    public List<ClienteGetDto> listClientesToListClientesGetDto(List<Cliente> clientes) {
        if (clientes == null) {
            return null;
        }

        // cria um lista de clientesGetDto e adiciona os clientes convertidos
        List<ClienteGetDto> list = new java.util.ArrayList<ClienteGetDto>(clientes.size());
        for (Cliente cliente : clientes) {
            list.add(clienteToClienteGetDto(cliente));
        }
        return list;
    }
}