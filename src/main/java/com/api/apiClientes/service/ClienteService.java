package com.api.apiClientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiClientes.model.Cliente;
import com.api.apiClientes.model.Contato;
import com.api.apiClientes.repository.ClienteRepository;
import com.api.apiClientes.repository.ContatoRepository;
import com.api.apiClientes.structs.StructsMappers;
import com.api.apiClientes.structs.dtos.ClienteGetDto;
import com.api.apiClientes.structs.dtos.ClientePostDto;

import jakarta.validation.Valid;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private StructsMappers structsMappers;

    public void SalvarClienteDto(ClientePostDto clienteDto) throws Exception {
        try {
            if (clienteDto == null || clienteDto.getContato() == null) {
                throw new Exception();
            }

            // primeiro salva o contato no banco de dados
            Contato contato = structsMappers.contatoDtoToContato(clienteDto.getContato());// transforma o contatoPostDto em um contato


            contatoRepository.save(contato);

            // depois salva o cliente no banco de dados atribuindo o contato que foi salvo anteriormente
            Cliente cliente = structsMappers.clientePostDtoToCliente(clienteDto);// transforma o clientePostDto em um cliente
            cliente.setContato(contato);

            clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new Exception("argumentos invalidos.");
        }
    }

    public ClienteGetDto ConsultarCliente(Integer id) throws Exception {
        try {
            // cria um novo ClienteGetDto
            ClienteGetDto clienteGetDto = new ClienteGetDto();

            // Busca o cliente no banco de dados e converte para clienteGetDto
            clienteGetDto = structsMappers.clienteToClienteGetDto(clienteRepository.getReferenceById(id));

            return clienteGetDto;

        } catch (Exception e) {
            throw new Exception("Nao foi possivel encontrar o cliente");
        }

    }

    public List<ClienteGetDto> ConsultarClientes() throws Exception {

        try {
            List<ClienteGetDto> clientesGetDto = structsMappers
                    .listClientesToListClientesGetDto(clienteRepository.findAll());

            return clientesGetDto;

        } catch (Exception e) {
            throw new Exception("Nao foi possivel listar os clientes");
        }

    }

    public void AlterarCliente(Integer id, @Valid ClientePostDto clientePostDto) {
        try {
            if(clientePostDto == null || clientePostDto.getContato() == null) {
                throw new Exception();
            }

            Cliente cliente = structsMappers.clientePostDtoToCliente(clientePostDto);
            cliente.setContato(structsMappers.contatoDtoToContato(clientePostDto.getContato()));

            // busca o contato do cliente no banco de dados e atribui o id do contato que foi buscado
            cliente.getContato().setId(clienteRepository.getReferenceById(id).getContato().getId());

            // busca a data de cadastro do cliente no banco de dados e atribui a data de cadastro que foi buscada
            cliente.setDataCadastro(clienteRepository.getReferenceById(id).getDataCadastro());

            cliente.setId(id);

            // salva o cliente no banco de dados
            clienteRepository.save(cliente);

            // salva o contato no banco de dados
            contatoRepository.save(cliente.getContato());

        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel alterar o cliente");
        }
    }

    public void DeletarCliente(Integer id) {
        try {
            // busca o cliente no banco de dados
            Cliente cliente = clienteRepository.getReferenceById(id);

            // busca o contato do cliente no banco de dados
            Contato contato = contatoRepository.getReferenceById(cliente.getContato().getId());

            // deleta o cliente no banco de dados
            clienteRepository.delete(cliente);

            // deleta o contato no banco de dados
            contatoRepository.delete(contato);

        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel deletar o cliente");
        }
    }

    public List<ClienteGetDto> ConsultarClienteNome(String nome) {
        try {
            List<ClienteGetDto> clientesGetDto = structsMappers
                    .listClientesToListClientesGetDto(clienteRepository.findByNomeContaining(nome));

            return clientesGetDto;

        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel listar os clientes");
        }
    }




}
