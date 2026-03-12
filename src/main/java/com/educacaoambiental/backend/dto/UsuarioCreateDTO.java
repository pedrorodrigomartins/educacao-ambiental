package com.educacaoambiental.backend.dto;

import com.educacaoambiental.backend.entity.enums.TipoUsuario;

public record UsuarioCreateDTO(
        Long id,
        String nome,
        String email,
        String senha,
        TipoUsuario tipoUsuario
) {}
