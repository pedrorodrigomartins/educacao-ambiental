package com.educacaoambiental.backend.repository;

import com.educacaoambiental.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> buscarPorEmail(String email);

    boolean existsByEmail(String email);
}
