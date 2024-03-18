package com.fmt.biblioteca.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LivroModel {
    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    private String autor;

    @Size(max = 4, message = "O ano de publicação deve ter no máximo 4 caracteres")
    private String anoPublicacao;
}
