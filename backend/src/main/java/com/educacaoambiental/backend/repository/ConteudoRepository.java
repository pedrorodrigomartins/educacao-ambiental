package com.educacaoambiental.backend.repository;

import com.educacaoambiental.backend.entity.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

    boolean existsByTitulo(String titulo);

}
