package com.Perfulandia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Perfulandia.model.ventas;

public interface ventasrepository extends JpaRepository<ventas, Long> {
}