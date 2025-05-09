package com.prueba.genesis.dtos;

import com.prueba.genesis.models.Cliente;

public class ClienteResponseDTO {
    private String dpi;
    private String nombre;

    // Constructors
    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String dpi, String nombre) {
        this.dpi = dpi;
        this.nombre = nombre;
    }

    // Static factory method for conversion from entity
    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getDpi(), cliente.getNombre());
    }

    // Getters and Setters
    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}