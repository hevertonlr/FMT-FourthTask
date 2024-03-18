package com.fmt.biblioteca.entities;

import com.fmt.biblioteca.models.VisitanteModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "visitante")  
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    @Column(length = 15)
    private String telefone;

    public Visitante(VisitanteModel model){
        this.nome = model.getNome();
        this.telefone = model.getTelefone();
    }
}
