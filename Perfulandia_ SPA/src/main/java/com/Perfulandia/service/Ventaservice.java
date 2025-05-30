package com.Perfulandia.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Perfulandia.model.Venta;
import com.Perfulandia.repository.Ventarepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Ventaservice {

    private final Ventarepository ventarepository;

    public Venta registrarVenta(Venta venta) {
        if (venta.getTotal() != null && venta.getTotal() > 100) {
            venta.setDescuento(venta.getTotal() * 0.1);
            venta.setTotal(venta.getTotal() - venta.getDescuento());
        }
        venta.setFechaventa(new Date());
        return ventarepository.save(venta);
    }
    
    public Venta procesarDevolucion(Long idVenta, String motivo) {
        Optional<Venta> ventaOpt = ventarepository.findById(idVenta);
        return ventaOpt.orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}