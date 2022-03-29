package com.marcos.server.model;

import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("JD")
@Table(name = "tb_personagem")
public class Personagem extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeJogador;
    private String classe;
    
    // @ManyToMany
    @Transient
    private ArrayList<Habilidade> habilidades;
    
}
