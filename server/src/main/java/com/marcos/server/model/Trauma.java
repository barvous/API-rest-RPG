package com.marcos.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trauma")
public class Trauma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trauma")
    private Integer id;

    @Column(name = "nome_trauma", nullable = false)
    private String nome;

    @Column(name = "gravidade_trauma", nullable = false)
    private String gravidade;

    //Relacionamento caso seja necessário listar os personagems que possuem esse trauma.
    // @ManyToMany(mappedBy = "traumas")
    // private ArrayList<Personagem> personagens;

    public Trauma() {
    }

    public Trauma(Integer id, String nome, String gravidade) {
        this.id = id;
        this.nome = nome;
        this.gravidade = gravidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    @Override
    public String toString() {
        return "Traumas [gravidade=" + gravidade + ", id=" + id + ", nome=" + nome + "]";
    }

}
