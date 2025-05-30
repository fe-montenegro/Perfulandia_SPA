package com.Perfulandia.service;
import  java.util.List;

import  org.springframework.stereotype.Service;

import com.Perfulandia.model.Producto;
import com.Perfulandia.repository.Productorepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Productoservice {

    private final Productorepository productoRepository;
    
    public List<Producto> searchProducts(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }

    public List<Producto> getAllProducts() {
        return productoRepository.findAll();
    }
}