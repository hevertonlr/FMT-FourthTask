package com.fmt.biblioteca.controllers;

import com.fmt.biblioteca.entities.Membro;
import com.fmt.biblioteca.models.MembroModel;
import com.fmt.biblioteca.services.MembroService;
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
@Tag(name = "Membros")
@RequestMapping("/membros")
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Membro.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
public class MembroController {
    private final MembroService service;

    public MembroController(MembroService service) {
        this.service = service;
    }

    @Operation(summary = "Criar Membro")
    @PostMapping
    public Membro create(@RequestBody MembroModel model) {
        return service.save(model);
    }

    @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = Membro.class)), mediaType = "application/json") })
    @Operation(summary = "Listar Membros")
    @GetMapping("listar")
    public List<Membro> list() {
        return service.list();
    }

    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) })
    @Operation(summary = "Remover Membro")
    @DeleteMapping("remover/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @Operation(summary = "Atualizar Membro")
    @PutMapping
    public Membro update(@RequestBody Membro entity) {
        return service.update(entity);
    }
}
