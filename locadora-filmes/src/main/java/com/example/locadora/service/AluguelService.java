package com.example.locadora.service;

import com.example.locadora.model.Aluguel;
import com.example.locadora.model.Filme;
import com.example.locadora.repository.AlugelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AluguelService {
    private final AlugelRepository aluguelRespository;
    private final FilmeService filmeService;

    public AluguelService(AlugelRepository alugelRepository, FilmeService filmeService) {
        this.aluguelRespository = alugelRepository;
        this.filmeService = filmeService;
    }

    public Aluguel saveAluguel(Aluguel aluguel) {
       try{
           return aluguelRespository.save(aluguel);
       }catch (Exception e){
           throw new RuntimeException("Erro ao salvar aluguel", e);
       }
    }

    public void saveAluguelAllFilmes(Aluguel aluguel) {
        try {
            List<Filme> filmes = filmeService.getAllFilmes();
            aluguel.setFilmes(filmes);
            aluguelRespository.save(aluguel);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar aluguel", e);
        }
    }

    public void saveAluguelFilmesId(Aluguel aluguel, List<Long> ids) {
        try{
            List<Filme> filmes = new ArrayList<>();
            for (Long id : ids) {
                filmes.add(filmeService.getFilmeByid(id));
            }
            aluguel.setFilmes(filmes);
            aluguelRespository.save(aluguel);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar aluguel", e);
        }
    }

    public List<Aluguel> getAllAlugueis(){
        return aluguelRespository.findAll();
    }

    public void deleteAluguel(long id) {
        try {
            aluguelRespository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Erro ao deletar aluguel", e);
        }
    }


}
