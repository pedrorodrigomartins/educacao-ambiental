package com.educacaoambiental.backend.controller;

import com.educacaoambiental.backend.entity.Categoria;
import com.educacaoambiental.backend.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria criarCategoria(@Valid @RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(201).body(novaCategoria).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(
            @PathVariable Long id,
            @Valid @RequestBody Categoria categoria) {
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.ok(categoriaAtualizada);
    }
}
