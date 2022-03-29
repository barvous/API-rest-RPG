package com.marcos.server.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("JD")
@Table(name = "personagem")
public class Personagem extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_jogador_personagem")
    private String nomeJogador;
    
    @Column(name = "classe_personagem")
    private String classe;
    
    // @ManyToMany
    @Transient
    private ArrayList<Habilidade> habilidades;
    
}
