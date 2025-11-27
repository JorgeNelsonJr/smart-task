package br.com.tarefas.smarttasks.controller;

import br.com.tarefas.smarttasks.model.Tarefa;
import br.com.tarefas.smarttasks.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    // 1. Rota para mostrar a tela inicial (GET /)
    @GetMapping("/")
    public String index(Model model) {
        // Busca todas as tarefas no banco e manda para o HTML
        model.addAttribute("tarefas", service.listarTodas());
        return "index"; // Vai procurar um arquivo index.html
    }

    // 2. Rota para salvar uma nova tarefa (POST /criar)
    @PostMapping("/criar")
    public String criar(Tarefa tarefa) {
        // Chama o serviço que usa a IA antes de salvar
        service.criarTarefaComIA(tarefa);
        // Recarrega a página inicial
        return "redirect:/";
    }
}