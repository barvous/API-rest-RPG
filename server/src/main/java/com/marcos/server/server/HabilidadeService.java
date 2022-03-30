package com.marcos.server.server;

import java.util.List;

import com.marcos.server.model.Habilidade;

public interface HabilidadeService {
          
    List<Habilidade> listarHabilidade();

    Habilidade buscarHabilidade(Long id);

    Habilidade criarHabilidade(Habilidade questao);

    Habilidade atualizarHabilidade(Habilidade questao, Long id);

    void removerHabilidade(Long id);

    void validarHabilidade(Habilidade habilidade);
}
