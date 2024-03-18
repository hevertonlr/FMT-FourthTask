package com.fmt.biblioteca.repositories;

import com.fmt.biblioteca.entities.Visitante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    List<Visitante> findAllByOrderByIdAsc();

    @Modifying
    @Transactional
    @Query("UPDATE Visitante e SET" +
            " e.nome = :nome," +
            " e.telefone = :telefone" +
            " WHERE e.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("telefone") String telefone);
}
