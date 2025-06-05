package com.AdministradorSistema.AdminSistema.controller;

import com.AdministradorSistema.AdminSistema.model.Usuario;
import com.AdministradorSistema.AdminSistema.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioContoller(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crear (@RequestBody Usuario usuario) {
        return service.crearUsuario(usuario);
    }
    
    @GetMapping
    public List<Usuario> listar() {
        return service.listarUsuario();
    }
    
    @PutMapping("/{id}")
    public Optional<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizarUsuario(id, usuario);
    }

    @PutMapping("/{id}/desactivar")
    public void desactivar(@PathVariable Long id) {
        service.desactivarUsuario(id);
    }

    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }

     @PutMapping("/{id}/permisos")
    public void asignarPermisos(@PathVariable Long id, @RequestBody Set<String> permisos) {
        service.asignarPermisos(id, permisos);
    }
}
