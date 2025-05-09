package com.prueba.genesis.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.genesis.dtos.PlanPagoDTO;
import com.prueba.genesis.dtos.PrestamoRequestDTO; 
import com.prueba.genesis.models.Cliente;
import com.prueba.genesis.models.Prestamo;
import com.prueba.genesis.repositories.ClienteRepository;
import com.prueba.genesis.repositories.PrestamoRepository;

@Service
public class PrestamoService {
    private final ClienteRepository clienteRepository;
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(ClienteRepository clienteRepository, PrestamoRepository prestamoRepository) {
        this.clienteRepository = clienteRepository;
        this.prestamoRepository = prestamoRepository;
    }

    @Transactional
    public Prestamo crearPrestamo(PrestamoRequestDTO prestamoRequest) {

        String dpiDelCliente = prestamoRequest.getDpiCliente(); 

        Cliente cliente = clienteRepository.findById(dpiDelCliente)
                .orElseThrow();

        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setMonto(prestamoRequest.getMonto());
        nuevoPrestamo.setNumeroCuotas(prestamoRequest.getNumeroCuotas());
        nuevoPrestamo.setCliente(cliente); 
        nuevoPrestamo.setFechaRegistro(LocalDate.now());

        return prestamoRepository.save(nuevoPrestamo);
    }

    public List<Prestamo> listaPrestamosPorCliente(String dpi) {
        return prestamoRepository.findByClienteDpi(dpi);
    }

    public Prestamo obtenerPrestamoPorCodigo(Long codigoPrestamo) {
        return prestamoRepository.findById(codigoPrestamo).orElse(null);
    }

    public List<Prestamo> listar() {
       return prestamoRepository.findAll();
    }


    //Calculo de cuotas segun el plazo, monto y fecha de registro.
    @Transactional(readOnly = true)
    public List<PlanPagoDTO> calcularPlanPago(Long codigoPrestamo, String dpiClient){
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(codigoPrestamo);
        Prestamo prestamo = prestamoOpt.get();
        List<PlanPagoDTO> planPago = new ArrayList<>();
        int montoTotal = prestamo.getMonto();
        int numeroCuotas = prestamo.getNumeroCuotas();
        LocalDate fechaRegistro = prestamo.getFechaRegistro();

        int montoCuota = (int) Math.floor((double) montoTotal / numeroCuotas + 151.9);

        for (int i = 1; i <= numeroCuotas; i++) {
            LocalDate fechaPago = fechaRegistro.plusMonths(i);
            PlanPagoDTO plan = new PlanPagoDTO(i, fechaPago, montoCuota);
            planPago.add(plan);
        }
        return planPago;
    }
}
