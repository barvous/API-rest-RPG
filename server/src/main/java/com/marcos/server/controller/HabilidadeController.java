package com.marcos.server.controller;

import java.util.List;

import com.marcos.server.model.Habilidade;
import com.marcos.server.repository.HabilidadeRepository;

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
    private HabilidadeRepository habilidadeRep;

    @PostMapping()
    public ResponseEntity<Habilidade> cadastrarHabilidade(@RequestBody Habilidade habilidade){
        //CADASTRA CLIENTE NO CONEXOS
        habilidadeRep.save(habilidade);

        return ResponseEntity.status(201).body(habilidade);
    }

    @GetMapping()
    public ResponseEntity<List<Habilidade>> listarHabilidades(){

        List<Habilidade> habilidades = habilidadeRep.findAll(); 

        return ResponseEntity.status(200).body(habilidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> buscarHabilidade(@PathVariable Long id){

        Habilidade habilidade = habilidadeRep.findById(id).get(); 

        return ResponseEntity.status(200).body(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> atualizarHabilidade(@RequestBody Habilidade habilidadeAlteracoes, @PathVariable Long id){

        habilidadeAlteracoes.setId(id);

        Habilidade habilidadeAlvo = habilidadeRep.findById(id).get();

        BeanUtils.copyProperties(habilidadeAlteracoes, habilidadeAlvo);

        habilidadeRep.save(habilidadeAlvo);

        return ResponseEntity.status(200).body(habilidadeAlvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habilidade> removerHabilidade(@PathVariable Long id){

        Habilidade habilidadeRemovida = habilidadeRep.findById(id).get(); 

        habilidadeRep.deleteById(id);

        return ResponseEntity.status(200).body(habilidadeRemovida);
    }
}
