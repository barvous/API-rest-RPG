package com.marcos.server.server;

import java.util.List;

import com.marcos.server.model.Trauma;

public interface TraumaService {
    
    List<Trauma> listarTrauma();

    Trauma buscarTrauma(Long id);

    Trauma criarTrauma(Trauma trauma);

    Trauma atualizarTrauma(Trauma trauma, Long id);

    void removerTrauma(Long id);

    void validarTrauma(Trauma trauma);
}
