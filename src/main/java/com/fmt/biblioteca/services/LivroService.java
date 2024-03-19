package com.fmt.biblioteca.services;

import com.fmt.biblioteca.entities.Livro;
import com.fmt.biblioteca.handlers.RestNotFoundException;
import com.fmt.biblioteca.models.LivroModel;
import com.fmt.biblioteca.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> list() {
        return repository.findAllByOrderByIdAsc();
    }

    public Livro save(LivroModel model) {
        return repository.save(new Livro(model));
    }

    public Livro update(Livro entity) {
        Livro existent = repository.findById(entity.getId())
                .orElseThrow(() -> new RestNotFoundException("Livro não encontrado!"));
        existent.setTitulo(entity.getTitulo());
        existent.setAutor(entity.getAutor());
        existent.setAnoPublicacao(entity.getAnoPublicacao());
        repository.update(existent.getId(),
                existent.getTitulo(),
                existent.getAutor(),
                existent.getAnoPublicacao());
        return existent;
    }

    public void delete(Long id) {
        int deleted = repository.deleteLivroById(id);
        if(deleted==0)
            throw new RestNotFoundException("Livro não encontrado!");
    }
}
