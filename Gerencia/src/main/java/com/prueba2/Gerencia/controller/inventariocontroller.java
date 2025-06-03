package com.prueba2.Gerencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba2.Gerencia.model.inventariomodel;
import com.prueba2.Gerencia.service.inventarioservice;

@RestController
@RequestMapping("/inventario")
public class inventariocontroller 
{
    @Autowired
    private inventarioservice inventarioservice;

    @GetMapping
    public List<inventariomodel> listar() {
        return inventarioservice.obtenerTodos();
    }

    @PostMapping
    public inventariomodel crear(@RequestBody inventariomodel producto) {
        return inventarioservice.crear(producto);
    }


    @GetMapping("/{id}")
    public inventariomodel obtener(@PathVariable Long id) {
        return inventarioservice.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    // Actualizar producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody inventariomodel producto) {
        inventarioservice.actualizar(id, producto);
        return ResponseEntity.noContent().build();
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioservice.eliminar(id);
    }

}
