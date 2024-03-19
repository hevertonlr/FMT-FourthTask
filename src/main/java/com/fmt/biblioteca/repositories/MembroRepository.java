package com.fmt.biblioteca.repositories;

import com.fmt.biblioteca.entities.Membro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
    List<Membro> findAllByOrderByIdAsc();

    Integer deleteMembroById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Membro e SET" +
            " e.nome = COALESCE(:nome,e.nome)," +
            " e.endereco = COALESCE(:endereco,e.endereco)," +
            " e.telefone = COALESCE(:telefone,e.telefone)" +
            " WHERE e.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("endereco") String endereco,
                @Param("telefone") String telefone);
}
