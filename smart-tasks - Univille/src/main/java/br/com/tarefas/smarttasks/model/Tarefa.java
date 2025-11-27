package br.com.tarefas.smarttasks.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Isso avisa ao Spring que esta classe é uma tabela no banco
public class Tarefa {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento (1, 2, 3...)
    private Long id;

    private String titulo;

    // Estes campos a IA que vai sugerir depois
    private String categoria;
    private String prioridade;

    @Column(length = 2000) // Aumentamos o tamanho para caber o texto da IA
    private String descricaoIa;

    private LocalDate dataCriacao;

    // --- CONSTRUTOR VAZIO (Obrigatório para o JPA) ---
    public Tarefa() {
        this.dataCriacao = LocalDate.now();
    }

    // --- CONSTRUTOR COM CAMPOS (Facilita para nós criarmos) ---
    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.dataCriacao = LocalDate.now();
    }

    // --- GETTERS E SETTERS (Sem Lombok, precisamos escrever todos) ---

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