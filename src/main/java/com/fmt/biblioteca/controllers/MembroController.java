package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Membro;
import com.fmt.biblioteca.models.MembroModel;
import com.fmt.biblioteca.services.MembroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Membros")
@RequestMapping("/membros")
public class MembroController {
    private final MembroService service;

    public MembroController(MembroService service) {
        this.service = service;
    }

    @PostMapping
    public Membro create(@RequestBody MembroModel model) {
        return service.save(model);
    }

    @GetMapping("listar")
    public List<Membro> list() {
        return service.list();
    }

    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    public Membro update(@RequestBody Membro entity) throws Exception {
        return service.update(entity);
    }
}
