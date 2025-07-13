package com.example.locadora;

import com.example.locadora.model.Filme;
import com.example.locadora.repository.FilmeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocadoraFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraFilmesApplication.class, args);
	}
	@Bean
	CommandLineRunner initData(FilmeRepository repository) {
		return args -> {
			Filme filme = new Filme();
			filme.setTitulo("Matrix");
			filme.setDiretor("Wachowski");
			filme.setGenero("Ficção Científica");
			filme.setSinopse("Um hacker descobre a verdade sobre o mundo");
			filme.setImagem("imagem.png");
			filme.setPreco(15.99);
			repository.save(filme);
		};
	}
}
