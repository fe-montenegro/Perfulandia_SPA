package com.Perfulandia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Perfulandia.model.Venta;

public interface Ventarepository extends JpaRepository<Venta, Long> {
}