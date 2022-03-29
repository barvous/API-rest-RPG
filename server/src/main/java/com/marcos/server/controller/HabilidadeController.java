package com.marcos.server.controller;

import com.marcos.server.repository.HabilidadeRepository;
import com.marcos.server.model.Habilidade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {
    
    private HabilidadeRepository habilidadeRep;

    @PostMapping()
    public ResponseEntity<Habilidade> cadastrarHabilidade(@RequestBody Habilidade habilidade){
        //CADASTRA CLIENTE NO CONEXOS
        habilidadeRep.save(habilidade);

        return ResponseEntity.status(201).body(habilidade);
    }
    

    @GetMapping()
    public ResponseEntity<Habilidade> buscarHabildades(@PathVariable Long id){

        Habilidade habilidade = habilidadeRep.getById(id); 

        return ResponseEntity.status(200).body(habilidade);
    }
}
