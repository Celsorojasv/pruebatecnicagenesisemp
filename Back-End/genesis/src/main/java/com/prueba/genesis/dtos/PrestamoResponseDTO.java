package com.prueba.genesis.dtos;

import com.prueba.genesis.models.Prestamo;
import java.time.LocalDate;

public class PrestamoResponseDTO {
    private Long codigoPrestamo;
    private Integer monto;
    private Integer numeroCuotas;
    private LocalDate fechaRegistro;
    private String dpiCliente; 

    public PrestamoResponseDTO() {
    }

    public PrestamoResponseDTO(Long codigoPrestamo, Integer monto, Integer numeroCuotas, LocalDate fechaRegistro, String dpiCliente) {
        this.codigoPrestamo = codigoPrestamo;
        this.monto = monto;
        this.numeroCuotas = numeroCuotas;
        this.fechaRegistro = fechaRegistro;
        this.dpiCliente = dpiCliente;
    }

    public static PrestamoResponseDTO fromEntity(Prestamo prestamo) {
        
        String clienteDpi = (prestamo.getCliente() != null) ? prestamo.getCliente().getDpi() : null;
        return new PrestamoResponseDTO(
            prestamo.getCodigoPrestamo(),
            prestamo.getMonto(),
            prestamo.getNumeroCuotas(),
            prestamo.getFechaRegistro(),
            clienteDpi
        );
    }
    public Long getCodigoPrestamo() { return codigoPrestamo; }
    public void setCodigoPrestamo(Long codigoPrestamo) { this.codigoPrestamo = codigoPrestamo; }
    public Integer getMonto() { return monto; }
    public void setMonto(Integer monto) { this.monto = monto; }
    public Integer getNumeroCuotas() { return numeroCuotas; }
    public void setNumeroCuotas(Integer numeroCuotas) { this.numeroCuotas = numeroCuotas; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getDpiCliente() { return dpiCliente; }
    public void setDpiCliente(String dpiCliente) { this.dpiCliente = dpiCliente; }
}