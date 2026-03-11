package com.educacaoambiental.backend.entity;

import com.educacaoambiental.backend.entity.enums.TipoConteudo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_conteudo")
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(nullable = false)
    @NotNull(message = "O tipo de conteúdo é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoConteudo tipoConteudo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "conteudo_categoria",
            joinColumns = @JoinColumn(name = "conteudo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

}
