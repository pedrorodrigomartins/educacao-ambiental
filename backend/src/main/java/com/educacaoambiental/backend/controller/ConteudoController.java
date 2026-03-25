package com.educacaoambiental.backend.controller;

import com.educacaoambiental.backend.entity.Conteudo;
import com.educacaoambiental.backend.service.ConteudoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    private final ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping
    public ResponseEntity<List<Conteudo>> listarConteudos() {
        return ResponseEntity.ok(conteudoService.listarConteudos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conteudo> buscarConteudo(@PathVariable Long id) {
        return ResponseEntity.ok(conteudoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Conteudo> criarConteudo(@Valid @RequestBody Conteudo conteudo) {
        Conteudo novoConteudo = conteudoService.criarConteudo(conteudo);
        return ResponseEntity.status(201).body(novoConteudo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteudo> atualizarConteudo(
            @PathVariable Long id,
            @Valid @RequestBody Conteudo conteudo
    ) {
        Conteudo conteudoAtualizado = conteudoService.atualizarConteudo(id, conteudo);
        return ResponseEntity.ok(conteudoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConteudo(@PathVariable Long id) {
        conteudoService.deletarConteudo(id);
        return ResponseEntity.noContent().build();
    }
}