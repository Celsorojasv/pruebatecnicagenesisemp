package com.prueba.genesis.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.genesis.models.Cliente;
import com.prueba.genesis.services.ClientService;
import com.prueba.genesis.dtos.ClienteResponseDTO; 
import java.util.List;
import java.util.stream.Collectors; 

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientService clientService;

    public ClienteController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clientService.crearCliente(cliente);
    }

    @GetMapping("/listar")
    public List<ClienteResponseDTO> listarClientes() {
        return clientService.listar().stream()
                            .map(ClienteResponseDTO::fromEntity)
                            .collect(Collectors.toList());
    }


}
