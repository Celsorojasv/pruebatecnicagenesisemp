package com.prueba.genesis.dtos;

import java.time.LocalDate;


public class PlanPagoDTO {
    private int numeroCuota;
    private LocalDate fechaPago;
    private int montoCuota;

    public PlanPagoDTO(int numeroCuota, LocalDate fechaPago, int montoCuota) {
        this.numeroCuota = numeroCuota;
        this.fechaPago = fechaPago;
        this.montoCuota = montoCuota;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(int montoCuota) {
        this.montoCuota = montoCuota;
    }
    


}
