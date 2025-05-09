package com.prueba.genesis.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference; 

@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_prestamo")
    private Long codigoPrestamo;

    @Column(name = "monto", nullable = false)
    private Integer monto;

       @Column(name = "numero_cuotas", nullable = false)
    private Integer numeroCuotas;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dpi_cliente", nullable = false)
    @JsonBackReference 
    private Cliente cliente;
    

    public Long getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(Long codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



}
