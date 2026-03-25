package com.educacaoambiental.backend.dto.request;


import jakarta.validation.constraints.NotEmpty;

public record RegistroUsuarioRequest(
        @NotEmpty(message = "Nome é obrigatório") String nome,
        @NotEmpty(message = "Email é obrigatório")String email,
        @NotEmpty(message = "Senha é obrigatório")String senha
) {}
