package com.marcos.server.controller;

import java.util.List;

import com.marcos.server.model.Trauma;
import com.marcos.server.server.TraumaService;

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
    private TraumaService traumaService;

    @PostMapping()
    public ResponseEntity<Trauma> cadastrarTrauma(@RequestBody Trauma trauma){
        //CADASTRA CLIENTE NO CONEXOS
        traumaService.criarTrauma(trauma);

        return ResponseEntity.status(201).body(trauma);
    }

    @GetMapping()
    public ResponseEntity<List<Trauma>> listarTraumas(){

        List<Trauma> traumas = traumaService.listarTrauma(); 

        return ResponseEntity.status(200).body(traumas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trauma> buscarTrauma(@PathVariable Long id){

        Trauma trauma = traumaService.buscarTrauma(id); 

        return ResponseEntity.status(200).body(trauma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trauma> atualizarTrauma(@RequestBody Trauma trauma, @PathVariable Long id){

        trauma = traumaService.atualizarTrauma(trauma, id);

        return ResponseEntity.status(200).body(trauma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trauma> removerTrauma(@PathVariable Long id){

        traumaService.removerTrauma(id);

        return ResponseEntity.status(200).build();
    }
}
