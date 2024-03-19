package com.fmt.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_emprestimo", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private LocalDateTime dataEmprestimo = LocalDateTime.now();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;

    @JsonIgnoreProperties({"emprestimos"})
    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livro livro;
    @JsonIgnoreProperties({"emprestimos"})
    @ManyToOne
    @JoinColumn(name = "id_membro", nullable = false)
    private Membro membro;

    public Emprestimo(Membro membro, Livro livro) {
        this.membro = membro;
        this.livro = livro;
    }
}
