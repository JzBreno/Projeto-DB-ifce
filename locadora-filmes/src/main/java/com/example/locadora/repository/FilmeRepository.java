package com.example.locadora.repository;

import com.example.locadora.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository <Filme, Long>{
}
