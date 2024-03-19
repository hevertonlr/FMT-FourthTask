package com.fmt.biblioteca.repositories;

import com.fmt.biblioteca.entities.Emprestimo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findAllByOrderByIdAsc();

    Optional<Emprestimo> findFirstByMembro_IdAndLivro_IdAndDataDevolucao(Long idMembro,
                                                                         Long idLivro,
                                                                         LocalDateTime dataDevolucao);

    boolean existsByMembro_IdAndLivro_IdAndDataDevolucao(Long idMembro,
                                                         Long idLivro,
                                                         LocalDateTime dataDevolucao);

    Integer deleteEmprestimoById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Emprestimo e SET" +
            " e.dataDevolucao = :dataDevolucao" +
            " WHERE e.id = :id")
    void update(@Param("id") Long id,
                @Param("dataDevolucao") LocalDateTime dataDevolucao);
}
