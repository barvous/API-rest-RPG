package com.marcos.server.server;

import java.util.List;

import com.marcos.server.model.Habilidade;

public interface HabilidadeService {
          
    List<Habilidade> listarHabilidade();

    Habilidade buscarHabilidade(Long id);

    Habilidade salvarHabilidade(Habilidade habilidade);

    void excluirHabilidade(Long id);

}
