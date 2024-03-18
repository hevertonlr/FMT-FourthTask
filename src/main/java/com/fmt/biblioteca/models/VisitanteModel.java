package com.fmt.biblioteca.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VisitanteModel {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;
}
