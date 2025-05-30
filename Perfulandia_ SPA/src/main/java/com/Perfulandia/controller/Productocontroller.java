package com.Perfulandia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Perfulandia.model.Producto;
import com.Perfulandia.service.Productoservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class Productocontroller {

    private final Productoservice productoServicio;
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarProductos(@RequestParam String nombre) {
        return new ResponseEntity<>(productoServicio.searchProducts(nombre), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerInventario() {
        return new ResponseEntity<>(productoServicio.getAllProducts(), HttpStatus.OK);
    }
}