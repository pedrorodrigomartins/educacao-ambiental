package com.educacaoambiental.backend.dto;

import com.educacaoambiental.backend.entity.enums.TipoUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        TipoUsuario tipoUsuario
) {}
