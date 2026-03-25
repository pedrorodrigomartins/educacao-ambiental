package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.dto.request.RegistroUsuarioRequest;
import com.educacaoambiental.backend.dto.response.RegistroUsuarioResponse;
import com.educacaoambiental.backend.entity.Usuario;
import com.educacaoambiental.backend.entity.enums.TipoUsuario;
import com.educacaoambiental.backend.exception.BusinessException;
import com.educacaoambiental.backend.exception.ResourceNotFoundException;
import com.educacaoambiental.backend.mapper.UsuarioMapper;
import com.educacaoambiental.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<RegistroUsuarioResponse> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponse)
                .toList();
    }

    public RegistroUsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado! id: " + id
                ));

        return UsuarioMapper.toResponse(usuario);
    }

    public RegistroUsuarioResponse buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado. Email: " + email
                ));

        return UsuarioMapper.toResponse(usuario);
    }

    public RegistroUsuarioResponse criarUsuario(RegistroUsuarioRequest dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Já existe um usuário com esse email");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Usuario usuario = UsuarioMapper.toEntity(
                dto,
                senhaCriptografada,
                TipoUsuario.ADMIN
        );

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }

    public RegistroUsuarioResponse atualizarUsuario(Long id, RegistroUsuarioRequest dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado! id: " + id
                ));

        if (!usuarioExistente.getEmail().equals(dto.email())
                && usuarioRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Já existe um usuário com esse email");
        }

        usuarioExistente.setNome(dto.nome());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setSenha(passwordEncoder.encode(dto.senha()));

        usuarioExistente = usuarioRepository.save(usuarioExistente);

        return UsuarioMapper.toResponse(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado. Id: " + id);
        }

        usuarioRepository.deleteById(id);
    }
}