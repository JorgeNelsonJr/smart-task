package br.com.tarefas.smarttasks.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity 
public class Tarefa {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String titulo;

    private String categoria;
    private String prioridade;

    @Column(length = 2000) 
    private String descricaoIa;

    private LocalDate dataCriacao;

    public Tarefa() {
        this.dataCriacao = LocalDate.now();
    }

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.dataCriacao = LocalDate.now();
    }

    // --- GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricaoIa() {
        return descricaoIa;
    }

    public void setDescricaoIa(String descricaoIa) {
        this.descricaoIa = descricaoIa;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
