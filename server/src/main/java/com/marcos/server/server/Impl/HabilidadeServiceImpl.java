package com.marcos.server.server.Impl;

import java.util.List;

import com.marcos.server.model.Habilidade;
import com.marcos.server.repository.HabilidadeRepository;
import com.marcos.server.server.HabilidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadeServiceImpl  implements HabilidadeService{
    
    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Override
    public List<Habilidade> listarHabilidade() {
        return habilidadeRepository.findAll();
    }

    @Override
    public Habilidade buscarHabilidade(Long id) {
        return habilidadeRepository.findById(id).get();
    }

    @Override
    public void criarHabilidade(Habilidade habilidade) {
        
        habilidadeRepository.save(habilidade);
        
    }

    @Override
    public Habilidade atualizarHabilidade(Habilidade habilidade) {
        habilidadeRepository.save(habilidade);
        return null;
    }

    @Override
    public Habilidade removerHabilidade(Long id) {
        habilidadeRepository.deleteById(id);
        return null;
    }
}
