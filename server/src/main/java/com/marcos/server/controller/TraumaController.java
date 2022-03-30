package com.marcos.server.controller;

import java.util.List;

import com.marcos.server.model.Trauma;
import com.marcos.server.repository.TraumaRepository;

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
@RequestMapping("/trauma")
public class TraumaController {
    
    @Autowired
    private TraumaRepository traumaRep;

    @PostMapping()
    public ResponseEntity<Trauma> cadastrarTrauma(@RequestBody Trauma trauma){
        //CADASTRA CLIENTE NO CONEXOS
        traumaRep.save(trauma);

        return ResponseEntity.status(201).body(trauma);
    }

    @GetMapping()
    public ResponseEntity<List<Trauma>> listarTraumas(){

        List<Trauma> traumas = traumaRep.findAll(); 

        return ResponseEntity.status(200).body(traumas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trauma> buscarTrauma(@PathVariable Long id){

        Trauma trauma = traumaRep.findById(id).get(); 

        return ResponseEntity.status(200).body(trauma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trauma> atualizarTrauma(@RequestBody Trauma traumaAlteracoes, @PathVariable Long id){

        traumaAlteracoes.setId(id);

        Trauma traumaAlvo = traumaRep.findById(id).get();

        BeanUtils.copyProperties(traumaAlteracoes, traumaAlvo);

        traumaRep.save(traumaAlvo);

        return ResponseEntity.status(200).body(traumaAlvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trauma> removerTrauma(@PathVariable Long id){

        Trauma traumaRemovida = traumaRep.findById(id).get(); 

        traumaRep.deleteById(id);

        return ResponseEntity.status(200).body(traumaRemovida);
    }
}
