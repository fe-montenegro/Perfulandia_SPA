package com.Perfulandia.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.Perfulandia.model.Factura;
import com.Perfulandia.repository.Facturarepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Facturaservice {

    private final Facturarepository Facturarepository;
    
    public Factura generarFactura(Factura factura) {
        factura.setFechafactura(new Date());
        Factura facturaGuardada = Facturarepository.save(factura);
        System.out.println("Enviando factura a: " + factura.getCorreocliente());
        return facturaGuardada;
    }
}