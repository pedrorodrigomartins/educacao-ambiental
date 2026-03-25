package com.educacaoambiental.backend.controller;

import com.educacaoambiental.backend.dto.request.RegistroUsuarioRequest;
import com.educacaoambiental.backend.dto.response.RegistroUsuarioResponse;
import com.educacaoambiental.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroUsuarioResponse>> listarUsuarios() {
        List<RegistroUsuarioResponse> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroUsuarioResponse> buscarPorId(@PathVariable Long id) {
        RegistroUsuarioResponse usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<RegistroUsuarioResponse> buscarPorEmail(@PathVariable String email) {
        RegistroUsuarioResponse usuario = usuarioService.buscarPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<RegistroUsuarioResponse> criarUsuario(
            @Valid @RequestBody RegistroUsuarioRequest dto
    ) {
        RegistroUsuarioResponse usuario = usuarioService.criarUsuario(dto);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroUsuarioResponse> atualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody RegistroUsuarioRequest dto
    ) {
        RegistroUsuarioResponse usuario = usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}