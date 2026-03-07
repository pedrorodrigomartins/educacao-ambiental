package com.educacaoambiental.backend.repository;

import com.educacaoambiental.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> buscarPorEmail(String email);

}
