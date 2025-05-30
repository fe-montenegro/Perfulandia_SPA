package com.Perfulandia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Perfulandia.model.Venta;
import com.Perfulandia.service.Ventaservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class Ventacontroller {

    private final Ventaservice ventaServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaServicio.registrarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }
    
    @PutMapping("/devolucion/{idVenta}")
    public ResponseEntity<Venta> procesarDevolucion(@PathVariable Long idVenta,
                                                    @RequestParam String motivo) {
        Venta venta = ventaServicio.procesarDevolucion(idVenta, motivo);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }
}