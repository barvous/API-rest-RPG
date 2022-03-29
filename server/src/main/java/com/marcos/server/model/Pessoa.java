package com.marcos.server.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING, length = 2)
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String familia;

    @Column(name = "data_nascimento")
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Column(nullable = false)
    private double altura;

    private String genero;

    @Column(nullable = false)
    private String aparencia;
    
    @Column(nullable = false)
    private String terraNatal;
    
    @Column(nullable = false)
    private Blob lore;

    // @ManyToMany
    // @JoinTable(
    //     joinColumns = @JoinColumn(name = "id_trauma"),
    //     inverseJoinColumns = @JoinColumn(name = "id_pessoa")
    //     )
    @Transient
    private ArrayList<Trauma> traumas;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String familia, Date dataNascimento, double altura, String genero,
            String aparencia, String terraNatal, Blob lore) {
        this.id = id;
        this.nome = nome;
        this.familia = familia;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.genero = genero;
        this.aparencia = aparencia;
        this.terraNatal = terraNatal;
        this.lore = lore;
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

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getTerraNatal() {
        return terraNatal;
    }

    public void setTerraNatal(String terraNatal) {
        this.terraNatal = terraNatal;
    }

    public Blob getLore() {
        return lore;
    }

    public void setLore(Blob lore) {
        this.lore = lore;
    }

    @Override
    public String toString() {
        return "Pessoa [altura=" + altura + ", aparencia=" + aparencia + ", dataNascimento=" + dataNascimento
                + ", familia=" + familia + ", genero=" + genero + ", id=" + id + ", lore=" + lore + ", nome=" + nome
                + ", terraNatal=" + terraNatal + "]";
    }

}
