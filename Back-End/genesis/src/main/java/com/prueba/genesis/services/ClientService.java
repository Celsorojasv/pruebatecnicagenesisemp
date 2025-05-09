package com.prueba.genesis.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.genesis.models.Cliente;
import com.prueba.genesis.repositories.ClienteRepository;

@Service
public class ClientService {
    private final ClienteRepository clienteRepository;

    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    
    public List<Cliente> listar() {return clienteRepository.findAll();}


    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerClientePorDpi(String dpi) {
        return clienteRepository.findById(dpi).orElse(null);
    }

    @Transactional
    public void eliminarCliente(String dpi) {
        clienteRepository.deleteById(dpi);
    }
}
