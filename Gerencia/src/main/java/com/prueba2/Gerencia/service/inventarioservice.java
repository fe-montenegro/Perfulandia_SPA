package com.prueba2.Gerencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba2.Gerencia.model.inventariomodel;
import com.prueba2.Gerencia.repository.inventariorepository;

@Service
public class inventarioservice {
    
    @Autowired
    private inventariorepository inventariorepository;

    public List<inventariomodel> obtenerTodos() {
        return inventariorepository.findAll();
    }

    public Optional<inventariomodel> buscarPorId(Long id) {
        return inventariorepository.findById(id);
    }

    public inventariomodel crear(inventariomodel producto) {
        return inventariorepository.save(producto);
    }

    public Optional<inventariomodel> actualizar(Long id, inventariomodel productonuevo) {
        return inventariorepository.findById(id).map(p -> {
            p.setNombre(productonuevo.getNombre());
            return inventariorepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        if (inventariorepository.existsById(id)) {
            inventariorepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
