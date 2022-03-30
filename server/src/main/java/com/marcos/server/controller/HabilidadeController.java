package com.marcos.server.controller;

import java.util.List;

import com.marcos.server.model.Habilidade;
import com.marcos.server.repository.HabilidadeRepository;
import com.marcos.server.server.HabilidadeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {
    
    @Autowired
    private HabilidadeService habilidadeService;

    @PostMapping()
    public ResponseEntity<Habilidade> cadastrarHabilidade(@RequestBody Habilidade habilidade){
        
        habilidadeService.criarHabilidade(habilidade);

        return ResponseEntity.status(201).body(habilidade);
    }

    @GetMapping()
    public ResponseEntity<List<Habilidade>> listarHabilidades(){

        List<Habilidade> habilidades = habilidadeService.listarHabilidade(); 

        return ResponseEntity.status(200).body(habilidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> buscarHabilidade(@PathVariable Long id){

        Habilidade habilidade = habilidadeService.buscarHabilidade(id); 

        return ResponseEntity.status(200).body(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> atualizarHabilidade(@RequestBody Habilidade habilidade, @PathVariable Long id){

        habilidade = habilidadeService.atualizarHabilidade(habilidade, id);

        return ResponseEntity.status(200).body(habilidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habilidade> removerHabilidade(@PathVariable Long id){

        habilidadeService.removerHabilidade(id);

        return ResponseEntity.status(200).build();
    }
}
