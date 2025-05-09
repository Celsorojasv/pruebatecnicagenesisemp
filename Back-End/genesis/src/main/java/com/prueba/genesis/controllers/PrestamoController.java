package com.prueba.genesis.controllers;

import com.prueba.genesis.models.Prestamo;
import com.prueba.genesis.services.PrestamoService;
import com.prueba.genesis.dtos.PrestamoResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prueba.genesis.dtos.PlanPagoDTO;
import com.prueba.genesis.dtos.PrestamoRequestDTO;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/crearPrestamo")
    public Prestamo crearPrestamo(@RequestBody PrestamoRequestDTO prestamoRequest) {
        return prestamoService.crearPrestamo(prestamoRequest);
    }

    @GetMapping("/listarPrestamos")
    public List<PrestamoResponseDTO> listarPrestamos() {
        return prestamoService.listar().stream()
                .map(PrestamoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    //Funcion para listar el resumen de pagos de un cliente segun su codigo de cliente y su dpi
    @GetMapping("/{codigoPrestamo}/cliente/{dpiCliente}/plan-pago")
    public ResponseEntity<?> obtenerPlanDePagos(
            @PathVariable Long codigoPrestamo,
            @PathVariable String dpiCliente) {

        List<PlanPagoDTO> planPagos = prestamoService.calcularPlanPago(codigoPrestamo, dpiCliente);

        return ResponseEntity.ok(planPagos);
    }

}
