package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.entity.Categoria;
import com.educacaoambiental.backend.exception.BusinessException;
import com.educacaoambiental.backend.exception.ResourceNotFoundException;
import com.educacaoambiental.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada! id: " + id
                ));
    }

    public Categoria criarCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new BusinessException("Essa categoria já existe");
        }

        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Long id, Categoria dadosAtualizados) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada! id: " + id
                ));

        categoria.setNome(dadosAtualizados.getNome());
        categoria.setDescricao(dadosAtualizados.getDescricao());

        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada! id: " + id
                ));

        categoriaRepository.delete(categoria);
    }
}