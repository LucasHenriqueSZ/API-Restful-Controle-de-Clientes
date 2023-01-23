package com.api.apiClientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiClientes.service.ClienteService;
import com.api.apiClientes.structs.dtos.ClienteGetDto;
import com.api.apiClientes.structs.dtos.ClientePostDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // http://localhost:8080/v1/cadastroCliente
    @PostMapping("/cadastroCliente") // cadastro de cliente
    public ResponseEntity<Void> CadastrarCliente(@Valid @RequestBody ClientePostDto clientePostDto) throws Exception {

        clienteService.SalvarClienteDto(clientePostDto);// salva o cliente no banco

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // http://localhost:8080/v1/cliente/{id}
    @GetMapping("/cliente/{id}") // consulta de cliente
    public ResponseEntity<ClienteGetDto> ConsultarClienteId(@PathVariable(value = "id") Integer id) {
        try {
            ClienteGetDto clienteDto = clienteService.ConsultarCliente(id);

            return new ResponseEntity<>(clienteDto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8080/v1/clientes
    @GetMapping("/clientes") // lista de todos clientes
    public ResponseEntity<List<ClienteGetDto>> ConsultarClientes() throws Exception {

        List<ClienteGetDto> clientesGetDto = clienteService.ConsultarClientes();

        return new ResponseEntity<>(clientesGetDto, HttpStatus.OK);
    }

    // http://localhost:8080/v1/alterarCliente/{id}
    @PutMapping("/alterarCliente/{id}") // editar cliente
    public ResponseEntity<Void> AlterarCliente(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody ClientePostDto clientePostDto) throws Exception {

        clienteService.AlterarCliente(id, clientePostDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:8080/v1/deletarCliente/{id}
    @DeleteMapping("/deletarCliente/{id}") // deletar cliente
    public ResponseEntity<Void> DeletarCliente(@PathVariable(value = "id") Integer id) throws Exception {

        clienteService.DeletarCliente(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:8080/v1/clienteNome/{nome}
    @GetMapping("/clienteNome/{nome}") // pesquisar cliente por nome
    public ResponseEntity<List<ClienteGetDto>> ConsultarClienteNome(@PathVariable(value = "nome") String nome)
            throws Exception {

        nome = nome.trim();

        if (nome.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        List<ClienteGetDto> clientesGetDto = clienteService.ConsultarClienteNome(nome);

        return new ResponseEntity<>(clientesGetDto, HttpStatus.OK);
    }

}
