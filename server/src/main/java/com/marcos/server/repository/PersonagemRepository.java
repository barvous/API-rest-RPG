package com.marcos.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.server.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    
}
