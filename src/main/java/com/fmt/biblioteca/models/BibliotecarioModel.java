package com.fmt.biblioteca.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BibliotecarioModel {
    @NotBlank(message = "O nome do bibliotecário é obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail do bibliotecário é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "A senha do bibliotecário é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;
}
