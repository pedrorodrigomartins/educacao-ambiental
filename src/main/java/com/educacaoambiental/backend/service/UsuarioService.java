package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.entity.Usuario;
import com.educacaoambiental.backend.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(
                () -> new RuntimeException(
                        "Usuário nao foi encontrado! id: " + id + ", tipo: " +
                                Usuario.class.getName()
                )
        );
    }

    public Usuario buscarPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorEmail(email);
        return usuario.orElseThrow(
                () -> new RuntimeException(
                        "Usuário nao foi encontrado! email: " + email + ", tipo: " +
                                Usuario.class.getName()
                )
        );
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Já existe um usuário com esse email");
        }

        return usuarioRepository.save(usuario);
    }

    public @Valid Usuario atualizarUsuario(@Valid Usuario obj) {
        Usuario usuarioExistente = usuarioRepository.findById(obj.getId())
                .orElseThrow(() -> new RuntimeException(
                        "Usuário não encontrado. Id: " + obj.getId()
                ));

        usuarioExistente.setNome(obj.getNome());
        usuarioExistente.setEmail(obj.getEmail());
        usuarioExistente.setSenha(obj.getSenha());
        usuarioExistente.setTipoUsuario(obj.getTipoUsuario());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado. Id: " + id);
        }

        usuarioRepository.deleteById(id);
    }
}
