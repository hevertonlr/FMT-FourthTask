package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Emprestimo;
import com.fmt.biblioteca.models.EmprestimoModel;
import com.fmt.biblioteca.services.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Empréstimos")
@RequestMapping("emprestimos")
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Emprestimo.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
public class EmprestimoController {
    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @Operation(summary = "Realizar Empréstimo")
    @PostMapping
    public Emprestimo create(@RequestBody EmprestimoModel model) {
        return service.create(model);
    }

    @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = Emprestimo.class)), mediaType = "application/json") })
    @Operation(summary = "Listar Empréstimos")
    @GetMapping("listar")
    public List<Emprestimo> list() {
        return service.list();
    }

    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) })
    @Operation(summary = "Remover Empréstimo")
    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Operation(summary = "Devolver Empréstimo")
    @PutMapping
    public Emprestimo update(@RequestBody EmprestimoModel model) {
        return service.update(model);
    }
}
