package com.educacaoambiental.backend.entity;

import com.educacaoambiental.backend.entity.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @Column(length = 255)
    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @NotNull(message = "O tipo de usuario é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
