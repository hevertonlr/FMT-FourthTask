package com.fmt.biblioteca.repositories;

import com.fmt.biblioteca.entities.Bibliotecario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    List<Bibliotecario> findAllByOrderByIdAsc();

    Integer deleteBibliotecarioById(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Bibliotecario e SET" +
            " e.nome = COALESCE(:nome,e.nome) ," +
            " e.email = COALESCE(:email,e.email)," +
            " e.senha = COALESCE(:senha,e.senha)" +
            " WHERE e.id = :id")
    void update(@Param("id") Long id,
                @Param("nome") String nome,
                @Param("email") String email,
                @Param("senha") String senha);
}
