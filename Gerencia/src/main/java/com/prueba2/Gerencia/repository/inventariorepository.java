package com.prueba2.Gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba2.Gerencia.model.inventariomodel;

public interface inventariorepository extends JpaRepository<inventariomodel, Long> {

}
