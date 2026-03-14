package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.dto.UsuarioCreateDTO;
import com.educacaoambiental.backend.dto.UsuarioResponseDTO;
import com.educacaoambiental.backend.entity.Usuario;
import com.educacaoambiental.backend.exception.BusinessException;
import com.educacaoambiental.backend.exception.ResourceNotFoundException;
import com.educacaoambiental.backend.mapper.UsuarioMapper;
import com.educacaoambiental.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado! id: " + id
                ));

        return UsuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado. Email: " + email
                ));

        return UsuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO criarUsuario(UsuarioCreateDTO dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Já existe um usuário com esse email");
        }

        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioCreateDTO dto) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado! id: " + id
                ));
        usuarioExistente.setNome(dto.nome());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setSenha(dto.senha());
        usuarioExistente.setTipoUsuario(dto.tipoUsuario());

        usuarioExistente = usuarioRepository.save(usuarioExistente);
        return UsuarioMapper.toResponseDTO(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado. Id: " + id);
        }

        usuarioRepository.deleteById(id);
    }
}
