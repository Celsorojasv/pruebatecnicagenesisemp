package com.prueba.genesis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.genesis.models.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByClienteDpi(String dpi);
}
