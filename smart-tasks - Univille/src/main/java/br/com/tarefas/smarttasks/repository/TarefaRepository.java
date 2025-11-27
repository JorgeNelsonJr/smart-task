package br.com.tarefas.smarttasks.repository;

import br.com.tarefas.smarttasks.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Só isso! O Spring Data JPA cria os métodos (save, findAll, delete) automaticamente.
}