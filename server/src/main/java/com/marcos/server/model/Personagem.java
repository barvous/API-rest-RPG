package com.marcos.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tb_personagem")
public class Personagem extends Pessoa{
    
    private int id;
    private String nomeJogador;
    private String classe;
    
}
