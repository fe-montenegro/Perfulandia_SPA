package com.Perfulandia.controller;

import  org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Perfulandia.model.Factura;
import com.Perfulandia.service.Facturaservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class Facturacontroller {

    private final Facturaservice facturaservice;
    
    @PostMapping("/generar")
    public ResponseEntity<Factura> generarFactura(@RequestBody Factura factura) {
        Factura generatedfactura = facturaservice.generarFactura(factura);
        return new ResponseEntity<>(generatedfactura, HttpStatus.CREATED);
    }
}
