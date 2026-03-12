package com.educacaoambiental.backend.mapper;

import com.educacaoambiental.backend.dto.UsuarioCreateDTO;
import com.educacaoambiental.backend.dto.UsuarioResponseDTO;
import com.educacaoambiental.backend.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTipoUsuario(dto.tipoUsuario());
        return usuario;
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }
}
