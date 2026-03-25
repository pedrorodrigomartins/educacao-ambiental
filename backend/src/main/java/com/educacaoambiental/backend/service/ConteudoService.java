package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.entity.Categoria;
import com.educacaoambiental.backend.entity.Conteudo;
import com.educacaoambiental.backend.exception.BusinessException;
import com.educacaoambiental.backend.exception.ResourceNotFoundException;
import com.educacaoambiental.backend.repository.CategoriaRepository;
import com.educacaoambiental.backend.repository.ConteudoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;
    private final CategoriaRepository categoriaRepository;

    public ConteudoService(
            ConteudoRepository conteudoRepository,
            CategoriaRepository categoriaRepository
    ) {
        this.conteudoRepository = conteudoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Conteudo> listarConteudos() {
        return conteudoRepository.findAll();
    }

    public Conteudo buscarPorId(Long id) {
        return conteudoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não foi encontrado"));
    }

    public Conteudo criarConteudo(Conteudo conteudo) {
        if (conteudoRepository.existsByTitulo(conteudo.getTitulo())) {
            throw new BusinessException("Esse conteúdo já existe");
        }

        if (conteudo.getCategoria() == null || conteudo.getCategoria().getId() == null) {
            throw new BusinessException("Categoria é obrigatória");
        }

        Long categoriaId = conteudo.getCategoria().getId();

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        conteudo.setCategoria(categoria);

        Conteudo conteudoSalvo = conteudoRepository.save(conteudo);

        return conteudoRepository.findById(conteudoSalvo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não foi encontrado após salvar"));
    }

    public Conteudo atualizarConteudo(Long id, Conteudo dadosAtualizados) {
        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não existe"));

        if (dadosAtualizados.getCategoria() == null || dadosAtualizados.getCategoria().getId() == null) {
            throw new BusinessException("Categoria é obrigatória");
        }

        Long categoriaId = dadosAtualizados.getCategoria().getId();

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        conteudo.setTitulo(dadosAtualizados.getTitulo());
        conteudo.setDescricao(dadosAtualizados.getDescricao());
        conteudo.setLinkArquivo(dadosAtualizados.getLinkArquivo());
        conteudo.setTipoConteudo(dadosAtualizados.getTipoConteudo());
        conteudo.setCategoria(categoria);

        Conteudo conteudoSalvo = conteudoRepository.save(conteudo);

        return conteudoRepository.findById(conteudoSalvo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não foi encontrado após atualizar"));
    }

    public void deletarConteudo(Long id) {
        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não encontrado"));

        conteudoRepository.delete(conteudo);
    }
}