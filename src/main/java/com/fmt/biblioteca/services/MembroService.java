package com.fmt.biblioteca.services;

import com.fmt.biblioteca.entities.Membro;
import com.fmt.biblioteca.models.MembroModel;
import com.fmt.biblioteca.repositories.MembroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {
    private final MembroRepository repository;

    public MembroService(MembroRepository repository) {
        this.repository = repository;
    }

    public List<Membro> list() {
        return repository.findAllByOrderByIdAsc();
    }

    public Membro save(MembroModel model) {
        return repository.save(new Membro(model));
    }

    public Membro update(Membro entity) throws Exception {

        repository.update(entity.getId(),
                entity.getNome(),
                entity.getEndereco(),
                entity.getTelefone());
        return entity;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
