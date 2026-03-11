package com.educacaoambiental.backend.entity;

import com.educacaoambiental.backend.entity.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nomeUsuario", length = 100, nullable = false, unique = true)
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100)
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "senha", length = 60, nullable = false)
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 60)
    private String senha;

    @NotNull(message = "O tipo de usuario é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
