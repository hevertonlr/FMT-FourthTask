package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Bibliotecario;
import com.fmt.biblioteca.models.BibliotecarioModel;
import com.fmt.biblioteca.services.BibliotecarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Bibliotecários")
@RequestMapping("bibliotecarios")
public class BibliotecarioController {
    private final BibliotecarioService service;

    public BibliotecarioController(BibliotecarioService service) {
        this.service = service;
    }

    @PostMapping
    public Bibliotecario create(@RequestBody BibliotecarioModel model) {
        return service.save(model);
    }

    @GetMapping("listar")
    public List<Bibliotecario> list() {
        return service.list();
    }

    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    public Bibliotecario update(@RequestBody Bibliotecario entity) throws Exception {
        return service.update(entity);
    }

}
