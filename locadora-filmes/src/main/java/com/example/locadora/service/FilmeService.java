package com.example.locadora.service;

import com.example.locadora.exceptions.FilmeNotFoundException;
import com.example.locadora.model.Filme;
import com.example.locadora.repository.FilmeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme saveFilme(Filme filme) {
        try {
            return filmeRepository.save(filme);
        } catch (Exception e) {
//            log.error("Erro ao salvar filme: {}", e.getMessage());
            throw new RuntimeException("Erro ao salvar filme", e);
        }
    }

    public Filme getFilmeByid(long id) {
        String message = String.format("Filme não encontrado, id: %d", id);
        return filmeRepository.findById(id)
                .orElseThrow(() -> new FilmeNotFoundException(message));
    }

    public void deleteFilme(long id) {
        try {
            Filme filme = getFilmeByid(id);
            filmeRepository.delete(filme);
        } catch (FilmeNotFoundException e) {
            throw e;
        } catch (Exception e) {
//            log.error("Erro ao deletar filme: {}", e.getMessage());
            throw new RuntimeException("Erro ao deletar filme", e);
        }
    }

    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }
}