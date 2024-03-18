package com.fmt.biblioteca.entities;

import com.fmt.biblioteca.models.BibliotecarioModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "bibliotecario")
public class Bibliotecario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bibliotecário é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O e-mail do bibliotecário é obrigatório")
    @Email(message = "Informe um e-mail válido")
    @Column(nullable = false, length = 100)
    private String email;

    @NotBlank(message = "A senha do bibliotecário é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    @Column(nullable = false, length = 100)
    private String senha;

    public Bibliotecario(BibliotecarioModel model){
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.senha = model.getSenha();
    }
}
