package com.educacaoambiental.backend.service;

import com.educacaoambiental.backend.entity.Conteudo;
import com.educacaoambiental.backend.repository.ConteudoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;

    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    public List<Conteudo> listarConteudos() {
        return conteudoRepository.findAll();
    }

    public Optional<Conteudo> buscarPorId(Long id) {
        if (conteudoRepository.existsById(id)) {
            return conteudoRepository.findById(id);
        } else {
            throw new RuntimeException("Conteudo não foi encontrado");
        }
    }

    public Conteudo criarConteudo(Conteudo conteudo) {
        if (conteudoRepository.existsByTitulo(conteudo.getTitulo())) {
            throw new RuntimeException("Esse conteúdo já existe");
        }

        return conteudoRepository.save(conteudo);
    }

    public Conteudo atualizarConteudo(Long id, Conteudo dadosAtualizados) {

        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteúdo não existe"));

        conteudo.setTitulo(dadosAtualizados.getTitulo());
        conteudo.setTipoConteudo(dadosAtualizados.getTipoConteudo());
        conteudo.setCategorias(dadosAtualizados.getCategorias());

        return conteudoRepository.save(conteudo);
    }

    public void deletarConteudo(Long id) {
        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteúdo não encontrado"));

        conteudoRepository.delete(conteudo);
    }
}
