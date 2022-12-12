package com.marcos.server.server;

import java.util.List;

import com.marcos.server.model.Personagem;

public interface PersonagemService {
    
    Personagem salvarPersonagem(Personagem personagem);

    List<Personagem> listarPersonagens();

    Personagem buscarPersonagem(Long idPersonagem);

    void excluirPersonagem(Long idPersonagem);
    
}
