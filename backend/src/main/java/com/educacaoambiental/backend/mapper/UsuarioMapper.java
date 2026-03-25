package com.educacaoambiental.backend.mapper;

import com.educacaoambiental.backend.dto.request.RegistroUsuarioRequest;
import com.educacaoambiental.backend.dto.response.RegistroUsuarioResponse;
import com.educacaoambiental.backend.entity.Usuario;
import com.educacaoambiental.backend.entity.enums.TipoUsuario;

public class UsuarioMapper {

    private UsuarioMapper(){}

    public static Usuario toEntity(
            RegistroUsuarioRequest request,
            String senhaCriptografada,
            TipoUsuario tipoUsuario
    ){
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(senhaCriptografada);
        usuario.setTipoUsuario(tipoUsuario);

        return usuario;
    }

    public static RegistroUsuarioResponse toResponse(Usuario usuario){
        return new RegistroUsuarioResponse(
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}