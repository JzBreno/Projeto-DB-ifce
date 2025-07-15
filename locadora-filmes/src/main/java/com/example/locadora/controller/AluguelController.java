package com.example.locadora.controller;

import com.example.locadora.model.Aluguel;
import com.example.locadora.service.AluguelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Aluguel")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }
    @GetMapping
    public ResponseEntity<Aluguel> getAllAlugueis(){
        return aluguelService.getAllAlugueis().isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(aluguelService.getAllAlugueis().get(0));
    }
//    TODO ajustar logica dos ids e validacao
    @PostMapping
    public ResponseEntity<String> salvarAluguelComFilmesPorIds(@RequestBody Map<String, List<Long>> payload) {
        List<Long> ids = payload.get("filmeIds");
        Aluguel aluguel = new Aluguel();
        aluguelService.saveAluguelFilmesId(aluguel, ids);
        return ResponseEntity.ok("Aluguel salvo com os filmes selecionados.");
    }




}
