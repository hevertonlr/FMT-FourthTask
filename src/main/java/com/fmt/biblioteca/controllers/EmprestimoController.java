package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Emprestimo;
import com.fmt.biblioteca.models.EmprestimoModel;
import com.fmt.biblioteca.services.EmprestimoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Empréstimos")
@RequestMapping("emprestimos")
public class EmprestimoController {
    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public Emprestimo create(@RequestBody EmprestimoModel model) throws RuntimeException {
        return service.create(model);
    }

    @GetMapping("listar")
    public List<Emprestimo> list() {
        return service.list();
    }

    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    public Emprestimo update(@RequestBody EmprestimoModel model) throws Exception {
        return service.update(model);
    }
}
