package com.fmt.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fmt.biblioteca.models.LivroModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "O autor é obrigatório")
    @Column(nullable = false)
    private String autor;

    @Size(max = 4, message = "O ano de publicação deve ter no máximo 4 caracteres")
    @Column(name = "ano_publicacao", length = 4)
    private String anoPublicacao;

    @Setter(AccessLevel.NONE)
    @JsonIgnoreProperties({"livro"})
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "livro", fetch = FetchType.EAGER)
    private List<Emprestimo> emprestimos;

    public Livro(LivroModel model){
        this.titulo = model.getTitulo();
        this.autor = model.getAutor();
        this.anoPublicacao = model.getAnoPublicacao();
    }
}
