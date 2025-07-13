package com.example.locadora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String sinopse;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private double preco;

    public Filme( String titulo, String sinopse) {
        this.titulo = titulo;
        this.sinopse = sinopse;
    }
}