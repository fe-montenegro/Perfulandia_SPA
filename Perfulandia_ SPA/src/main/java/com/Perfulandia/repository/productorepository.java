package com.Perfulandia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Perfulandia.model.producto;

public interface productorepository extends JpaRepository<producto, Long> {
    List<producto> findByNameContaining(String name);
}