package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Livro;
import com.fmt.biblioteca.models.LivroModel;
import com.fmt.biblioteca.services.LivroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Livros")
@RequestMapping("livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public Livro create(@RequestBody LivroModel model) {
        return service.save(model);
    }

    @GetMapping("listar")
    public List<Livro> list() {
        return service.list();
    }

    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    public Livro update(@RequestBody Livro entity) throws Exception {
        return service.update(entity);
    }
}
