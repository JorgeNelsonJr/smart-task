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

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tarefas", service.listarTodas());
        return "index";
    }

    @PostMapping("/criar")
    public String criar(Tarefa tarefa) {
        service.criarTarefaComIA(tarefa);
        return "redirect:/";
    }

}
