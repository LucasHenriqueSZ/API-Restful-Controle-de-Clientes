package com.api.apiClientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiClientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContaining(String nome);

}
