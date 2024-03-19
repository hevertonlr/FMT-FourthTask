package com.fmt.biblioteca.repositories;

import com.fmt.biblioteca.entities.Livro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByOrderByIdAsc();

    Integer deleteLivroById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Livro e SET" +
            " e.titulo = COALESCE(:titulo,e.titulo)," +
            " e.autor = COALESCE(:autor,e.autor)," +
            " e.anoPublicacao = COALESCE(:anoPublicacao,e.anoPublicacao)" +
            " WHERE e.id = :id")
    void update(@Param("id") Long id,
                @Param("titulo") String titulo,
                @Param("autor") String autor,
                @Param("anoPublicacao") String anoPublicacao);
}
