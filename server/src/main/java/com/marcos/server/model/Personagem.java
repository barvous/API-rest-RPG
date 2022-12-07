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
    private Long id;

    @Column(name = "nome_jogador_personagem")
    private String nomeJogador;

    @Column(name = "nome_personagem")
    private String nomePersonagem;

    @Column(name = "origem_personagem")
    private String origem;

    @Column(name = "classe_personagem")
    private String classe;

    @Column(name = "nex")
    private Integer nex;

    @Column(name = "atributo_forca", nullable = false)
    private Integer atributoForca;

    @Column(name = "atributo_agilidade", nullable = false)
    private Integer atributoAgilidade;

    @Column(name = "atributo_intelecto", nullable = false)
    private Integer atributoIntelecto;

    @Column(name = "atributo_vigor", nullable = false)
    private Integer atributoVigor;

    @Column(name = "atributo_presenca", nullable = false)
    private Integer atributoPresenca;

    // Construtores
    public Personagem() {
    }

    //Gets e Sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getNex() {
        return nex;
    }

    public void setNex(Integer nex) {
        this.nex = nex;
    }

    public Integer getAtributoForca() {
        return atributoForca;
    }

    public void setAtributoForca(Integer atributoForca) {
        this.atributoForca = atributoForca;
    }

    public Integer getAtributoAgilidade() {
        return atributoAgilidade;
    }

    public void setAtributoAgilidade(Integer atributoAgilidade) {
        this.atributoAgilidade = atributoAgilidade;
    }

    public Integer getAtributoIntelecto() {
        return atributoIntelecto;
    }

    public void setAtributoIntelecto(Integer atributoIntelecto) {
        this.atributoIntelecto = atributoIntelecto;
    }

    public Integer getAtributoVigor() {
        return atributoVigor;
    }

    public void setAtributoVigor(Integer atributoVigor) {
        this.atributoVigor = atributoVigor;
    }

    public Integer getAtributoPresenca() {
        return atributoPresenca;
    }

    public void setAtributoPresenca(Integer atributoPresenca) {
        this.atributoPresenca = atributoPresenca;
    }

    // @ManyToMany
    // @Transient
    // private ArrayList<Habilidade> habilidades;
    
}
