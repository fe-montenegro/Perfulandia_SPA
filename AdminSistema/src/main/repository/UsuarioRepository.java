package com.AdministradorSistema.AdminSistema.repository;

import com.AdministradorSistema.AdminSistema.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
