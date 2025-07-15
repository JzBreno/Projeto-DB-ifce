
package com.example.locadora.controller;

import com.example.locadora.model.Filme;
import com.example.locadora.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getAllFilmes() {
        return ResponseEntity.ok(filmeService.getAllFilmes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable long id) {
        return ResponseEntity.ok(filmeService.getFilmeByid(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable long id) {
        filmeService.deleteFilme(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveFilme(@RequestBody Filme filme) {
        filmeService.saveFilme(filme);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFilme(@PathVariable long id, @RequestBody Filme filme) {
        Filme filmesaved = filmeService.getFilmeByid(id);
        filme.setId(filmesaved.getId());
        deleteFilme(id);
        saveFilme(filme);
        return ResponseEntity.ok().build();
    }
}