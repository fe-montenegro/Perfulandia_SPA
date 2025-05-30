package com.Perfulandia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Perfulandia.model.Factura;


public interface Facturarepository extends JpaRepository<Factura, Long> {
}