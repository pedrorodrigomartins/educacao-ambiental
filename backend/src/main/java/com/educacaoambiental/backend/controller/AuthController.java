package com.educacaoambiental.backend.controller;

import com.educacaoambiental.backend.dto.request.LoginRequest;
import com.educacaoambiental.backend.dto.request.RegistroUsuarioRequest;
import com.educacaoambiental.backend.dto.response.LoginResponse;
import com.educacaoambiental.backend.dto.response.RegistroUsuarioResponse;
import com.educacaoambiental.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/registro")
    public ResponseEntity<RegistroUsuarioResponse> registro(
            @Valid @RequestBody RegistroUsuarioRequest request
    ) {
        return ResponseEntity.ok(authService.registro(request));
    }
}