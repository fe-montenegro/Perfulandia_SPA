package com.AdministradorSistema.AdminSistema.service;

import com.AdministradorSistema.AdminSistema.model.Usuario;
import com.AdministradorSistema.AdminSistema.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository
    }

    public Usuario crearUsuario(Usuario usuario) {
        usuario.setActivo(true);
        return repository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> actualizarUsuario(Long id, Usuario nuevo) {
        return repository.findById(id).map(u -> {
            u.setNombre(nuevo.getNombre());
            u.setRol(nuevo.getRol());
            u.setCorreo(nuevo.getCorreo());
            return repository.save(u);
        });
    }

    public void desactivarUsuario(Long id) {
        repository.findById(id).ifPresent(u -> {
            u.setActivo(false);
            repository.save(u);
        });
    }

    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }

    public void asignarPermisos(Long id, Set<String> permisos) {
        repository.findById(id).ifPresent(u -> {
            u.setPermisos(permisos);
            repository.save(u);
        });
    }
}
