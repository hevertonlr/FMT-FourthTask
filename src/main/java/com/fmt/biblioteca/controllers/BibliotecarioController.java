package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Bibliotecario;
import com.fmt.biblioteca.models.BibliotecarioModel;
import com.fmt.biblioteca.services.BibliotecarioService;
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
@Tag(name = "Bibliotecários")
@RequestMapping("bibliotecarios")
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Bibliotecario.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
public class BibliotecarioController {
    private final BibliotecarioService service;

    public BibliotecarioController(BibliotecarioService service) {
        this.service = service;
    }

    @Operation(summary = "Criar Bibliotecario")
    @PostMapping
    public Bibliotecario create(@RequestBody BibliotecarioModel model) {
        return service.save(model);
    }

    @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = Bibliotecario.class)), mediaType = "application/json") })
    @Operation(summary = "Listar Bibliotecarios")
    @GetMapping("listar")
    public List<Bibliotecario> list() {
        return service.list();
    }

    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) })
    @Operation(summary = "Remover Bibliotecario")
    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Operation(summary = "Atualizar Bibliotecario")
    @PutMapping
    public Bibliotecario update(@RequestBody Bibliotecario entity) {
        return service.update(entity);
    }

}
