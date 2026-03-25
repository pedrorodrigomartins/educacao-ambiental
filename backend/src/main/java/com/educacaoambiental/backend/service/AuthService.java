package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.dto.request.LoginRequest;
import com.educacaoambiental.backend.dto.request.RegistroUsuarioRequest;
import com.educacaoambiental.backend.dto.response.LoginResponse;
import com.educacaoambiental.backend.dto.response.RegistroUsuarioResponse;
import com.educacaoambiental.backend.entity.enums.TipoUsuario;
import com.educacaoambiental.backend.exception.BusinessException;
import com.educacaoambiental.backend.mapper.UsuarioMapper;
import com.educacaoambiental.backend.repository.UsuarioRepository;
import com.educacaoambiental.backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.senha()
                )
        );

        String token = jwtService.generateToken(request.email());
        return new LoginResponse(token);
    }

    public RegistroUsuarioResponse registro(RegistroUsuarioRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new BusinessException("Já existe um usuário com esse email");
        }

        String senhaCriptografada = passwordEncoder.encode(request.senha());

        var usuario = UsuarioMapper.toEntity(
                request,
                senhaCriptografada,
                TipoUsuario.ADMIN
        );

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }
}