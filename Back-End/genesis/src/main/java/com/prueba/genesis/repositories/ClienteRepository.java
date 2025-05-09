package com.prueba.genesis.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.genesis.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
}
