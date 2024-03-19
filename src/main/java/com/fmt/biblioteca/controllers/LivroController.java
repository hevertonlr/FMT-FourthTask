package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Livro;
import com.fmt.biblioteca.models.LivroModel;
import com.fmt.biblioteca.services.LivroService;
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
@Tag(name = "Livros")
@RequestMapping("livros")
@ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Livro.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @Operation(summary = "Criar Livro")
    @PostMapping
    public Livro create(@RequestBody LivroModel model) {
        return service.save(model);
    }

    @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Livro.class)), mediaType = "application/json")})
    @Operation(summary = "Listar Livros")
    @GetMapping("listar")
    public List<Livro> list() {
        return service.list();
    }

    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())})
    @Operation(summary = "Deletar Livro")
    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Operation(summary = "Atualizar Livro")
    @PutMapping
    public Livro update(@RequestBody Livro entity) {
        return service.update(entity);
    }
}
