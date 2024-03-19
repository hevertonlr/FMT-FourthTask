package com.fmt.biblioteca.services;

import com.fmt.biblioteca.entities.Visitante;
import com.fmt.biblioteca.handlers.RestNotFoundException;
import com.fmt.biblioteca.models.VisitanteModel;
import com.fmt.biblioteca.repositories.VisitanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitanteService {
    private final VisitanteRepository repository;

    public VisitanteService(VisitanteRepository repository) {
        this.repository = repository;
    }

    public List<Visitante> list() {
        return repository.findAllByOrderByIdAsc();
    }

    public Visitante save(VisitanteModel model) {
        return repository.save(new Visitante(model));
    }

    public Visitante update(Visitante entity) throws RestNotFoundException {
        Visitante existent = repository.findById(entity.getId())
                .orElseThrow(() -> new RestNotFoundException("Visitante não encontrado!"));
        existent.setId(entity.getId());
        existent.setNome(entity.getNome());
        existent.setTelefone(entity.getTelefone());
        repository.update(existent.getId(),
                existent.getNome(),
                existent.getTelefone());
        return existent;
    }

    public void delete(Long id) {
        int deleted = repository.deleteVisitanteById(id);
        if(deleted==0)
            throw new RestNotFoundException("Visitante não encontrado!");
    }
}
