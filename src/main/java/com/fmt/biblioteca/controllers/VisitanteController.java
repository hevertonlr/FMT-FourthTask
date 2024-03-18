package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Visitante;
import com.fmt.biblioteca.models.VisitanteModel;
import com.fmt.biblioteca.services.VisitanteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Visitantes")
@RequestMapping("/visitantes")
public class VisitanteController {
    private final VisitanteService service;

    public VisitanteController(VisitanteService service) {
        this.service = service;
    }

    @PostMapping
    public Visitante create(@RequestBody VisitanteModel model) {
        return service.save(model);
    }

    @GetMapping("listar")
    public List<Visitante> list() {
        return service.list();
    }

    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    public Visitante update(@RequestBody Visitante entity) throws Exception {
        return service.update(entity);
    }
}
