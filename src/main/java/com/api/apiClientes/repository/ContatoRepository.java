package com.api.apiClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiClientes.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato,Integer> {
    
}
