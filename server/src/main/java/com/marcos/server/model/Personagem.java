package com.marcos.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("JD")
@Table(name = "personagem")
public class Personagem {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_jogador_personagem")
    private String nomeJogador;

    @Column(name = "nome_personagem")
    private String nomePersonagem;

    @Column(name = "origem_personagem")
    private String origem;

    @Column(name = "classe_personagem")
    private String classe;

    @Column(name = "nex")
    private int nex;

    @Column(name = "atributo_forca", nullable = false)
    private int atributoForca;

    @Column(name = "atributo_agilidade", nullable = false)
    private int atributoAgilidade;

    @Column(name = "atributo_inteligencia", nullable = false)
    private int atributoInteligencia;

    @Column(name = "atributo_vigor", nullable = false)
    private int atributoVigor;

    @Column(name = "atributo_presenca", nullable = false)
    private int atributoPresenca;

    // Construtores
    public Personagem() {
    }

    //Gets e Sets

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNex() {
        return nex;
    }

    public void setNex(int nex) {
        this.nex = nex;
    }

    public int getAtributoForca() {
        return atributoForca;
    }

    public void setAtributoForca(int atributoForca) {
        this.atributoForca = atributoForca;
    }

    public int getAtributoAgilidade() {
        return atributoAgilidade;
    }

    public void setAtributoAgilidade(int atributoAgilidade) {
        this.atributoAgilidade = atributoAgilidade;
    }

    public int getAtributoInteligencia() {
        return atributoInteligencia;
    }

    public void setAtributoInteligencia(int atributoInteligencia) {
        this.atributoInteligencia = atributoInteligencia;
    }

    public int getAtributoVigor() {
        return atributoVigor;
    }

    public void setAtributoVigor(int atributoVigor) {
        this.atributoVigor = atributoVigor;
    }

    public int getAtributoPresenca() {
        return atributoPresenca;
    }

    public void setAtributoPresenca(int atributoPresenca) {
        this.atributoPresenca = atributoPresenca;
    }

    // @ManyToMany
    // @Transient
    // private ArrayList<Habilidade> habilidades;
    
}
