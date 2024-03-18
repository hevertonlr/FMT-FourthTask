package com.fmt.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmt.biblioteca.models.MembroModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "membro")
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Size(max = 170, message = "O endereço deve ter no máximo 170 caracteres")
    @Column(length = 170)
    private String endereco;

    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    @Column(length = 15)
    private String telefone;

    @Setter(AccessLevel.NONE)
    @JsonIgnoreProperties({"membro"})
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "membro", fetch = FetchType.EAGER)
    private List<Emprestimo> emprestimos;

    public Membro(MembroModel model){
        this.nome = model.getNome();
        this.endereco = model.getEndereco();
        this.telefone = model.getTelefone();
    }
}
