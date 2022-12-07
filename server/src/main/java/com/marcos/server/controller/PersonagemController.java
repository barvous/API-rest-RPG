package com.marcos.server.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.server.model.Personagem;
import com.marcos.server.server.PersonagemService;

@CrossOrigin
@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService personagemService;

    PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping()
    public ResponseEntity<Personagem> inserirPersonagem(@RequestBody Personagem personagem) {
        personagemService.salvarPersonagem(personagem);
        
        return ResponseEntity.status(201).build();
    }

    @GetMapping()
    public ResponseEntity<List<Personagem>> listarPersonagens() {

        List<Personagem> listaPersonagens = personagemService.listarPersonagens();

        return ResponseEntity.ok().body(listaPersonagens);
    }

    @GetMapping(path = "/{idPersonagem}")
    public ResponseEntity<Personagem> buscarPersonagem(@PathVariable Long idPersonagem) {

        Personagem personagem = personagemService.buscarPersonagem(idPersonagem);

        return ResponseEntity.ok().body(personagem);
    }

    @DeleteMapping(path = "/{idPersonagem}")
    public ResponseEntity<Personagem> alterarPersonagem(@PathVariable Long idPersonagem) {

        personagemService.deletarPersonagem(idPersonagem);

        return ResponseEntity.ok().build();
    }

}
