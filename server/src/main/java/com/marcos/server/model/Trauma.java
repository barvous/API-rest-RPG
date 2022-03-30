package com.marcos.server.model;

import java.sql.Blob;

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
    private Long id;

    @Column(name = "nome_trauma", nullable = false)
    private String nome;

    @Column(name = "gravidade_trauma", nullable = false)
    private String gravidade;

    @Column(name = "descricao_trauma")
    private Blob descricao;

    //Relacionamento caso seja necessário listar os personagems que possuem esse trauma.
    // @ManyToMany(mappedBy = "traumas")
    // private ArrayList<Personagem> personagens;

    public Trauma() {
    }

    public Trauma(Long id, String nome, String gravidade, Blob descricao) {
        this.id = id;
        this.nome = nome;
        this.gravidade = gravidade;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Blob getDescricao() {
        return descricao;
    }

    public void setDescricao(Blob descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Trauma [descricao=" + descricao + ", gravidade=" + gravidade + ", id=" + id + ", nome=" + nome + "]";
    }

}
