package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.entity.Categoria;
import com.educacaoambiental.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        if (categoriaRepository.existsById(id)) {
            return categoriaRepository.findById(id);
        } else {
            throw new RuntimeException("Categoria nao foi encontrada");
        }
        // Se não encontrar, lançar exceção
        // (ex: RuntimeException ou criar uma personalizada depois)
    }

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
        // Validar se já existe categoria com
        // mesma descrição (opcional, mas recomendado)
    }

    public void deletarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Impossivel, Categoria essa nao existe");
        }
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.setConteudos(categoria.getConteudos());
        categoria.setDescricao(categoria.getDescricao());

        return categoriaRepository.save(categoria);
    }
}
