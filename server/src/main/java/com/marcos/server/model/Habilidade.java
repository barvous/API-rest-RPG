package com.marcos.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habilidade")
public class Habilidade implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidade", nullable = false)
    private Long id;

    @Column(name = "nome_habilidade", nullable = false)
    private String nome;

    @Column(name = "descricao_habilidade", nullable = false, length = 500)
    private String descricao;

    @Column(name = "tipo_habilidade", nullable = false)
    private String tipo;
    
    @Column(name = "custo")
    private String custo;

    @Column(name = "valor_habilidade")
    private String valor;

    public Habilidade() {
    }

    public Habilidade(Long id, String nome, String descricao, String tipo, String custo, String valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.custo = custo;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Habilidade [custo=" + custo + ", descricao=" + descricao + ", id=" + id + ", nome=" + nome + ", tipo="
                + tipo + ", valor=" + valor + "]";
    }

}
