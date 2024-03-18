package com.fmt.biblioteca.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MembroModel {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Size(max = 170, message = "O endereço deve ter no máximo 170 caracteres")
    private String endereco;

    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;
}
