package com.Perfulandia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Perfulandia.model.Producto;

public interface Productorepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContaining(String nombre);
}