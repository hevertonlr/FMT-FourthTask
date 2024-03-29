package com.fmt.biblioteca.services;


import com.fmt.biblioteca.entities.Bibliotecario;
import com.fmt.biblioteca.handlers.RestNotFoundException;
import com.fmt.biblioteca.models.BibliotecarioModel;
import com.fmt.biblioteca.repositories.BibliotecarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService {
    private final BibliotecarioRepository repository;

    public BibliotecarioService(BibliotecarioRepository repository) {
        this.repository = repository;
    }

    public List<Bibliotecario> list() {
        return repository.findAllByOrderByIdAsc();
    }

    public Bibliotecario save(BibliotecarioModel model) {
        return repository.save(new Bibliotecario(model));
    }

    public Bibliotecario update(Bibliotecario entity) {
        Bibliotecario existent = repository.findById(entity.getId())
                .orElseThrow(() -> new RestNotFoundException("Bibliotecário não encontrado!"));
        existent.setNome(entity.getNome());
        existent.setEmail(entity.getEmail());
        existent.setSenha(entity.getSenha());
        repository.update(existent.getId(),
                existent.getNome(),
                existent.getEmail(),
                existent.getSenha());
        return existent;
    }

    public void delete(Long id) {
        int deleted = repository.deleteBibliotecarioById(id);
        if(deleted==0)
            throw new RestNotFoundException("Emprestimo não encontrado!");
    }


}
