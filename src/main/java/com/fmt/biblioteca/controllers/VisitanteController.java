package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Visitante;
import com.fmt.biblioteca.models.VisitanteModel;
import com.fmt.biblioteca.services.VisitanteService;
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
@Tag(name = "Visitantes")
@RequestMapping("/visitantes")
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Visitante.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
public class VisitanteController {
    private final VisitanteService service;

    public VisitanteController(VisitanteService service) {
        this.service = service;
    }

    @Operation(summary = "Criar Visitante")
    @PostMapping
    public Visitante create(@RequestBody VisitanteModel model) {
        return service.save(model);
    }

    @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = Visitante.class)), mediaType = "application/json") })
    @Operation(summary = "Listar Visitantes")
    @GetMapping("listar")
    public List<Visitante> list() {
        return service.list();
    }

    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) })
    @Operation(summary = "Deletar Visitante")
    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Operation(summary = "Atualizar Visitante")
    @PutMapping
    public Visitante update(@RequestBody Visitante entity) {
        return service.update(entity);
    }
}
