package br.com.tarefas.smarttasks.service;

import br.com.tarefas.smarttasks.model.Tarefa;
import br.com.tarefas.smarttasks.repository.TarefaRepository;
import org.springframework.ai.chat.model.ChatModel; // Importante: Spring AI 1.x usa ChatModel
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final ChatModel chatModel;

    // O Spring injeta o ChatModel (Gemini) e o Repository automaticamente aqui
    public TarefaService(TarefaRepository repository, ChatModel chatModel) {
        this.repository = repository;
        this.chatModel = chatModel;
    }

    public List<Tarefa> listarTodas() {
        return repository.findAll();
    }

    public Tarefa criarTarefaComIA(Tarefa tarefa) {
        // 1. Montamos a pergunta para o Gemini
        String prompt = """
                Você é um assistente de organização. Analise a seguinte tarefa: %s
                
                Responda APENAS neste formato simples (sem markdown, sem json):
                Categoria: [sugira uma categoria curta ex: Trabalho, Pessoal, Estudo]
                Prioridade: [sugira Baixa, Média ou Alta]
                Descrição: [uma descrição melhorada de até 1 frase]
                """.formatted(tarefa.getTitulo());

        // 2. Chamamos o Gemini
        String respostaDaIA = chatModel.call(prompt);

        // 3. Processamos a resposta (uma gambiarra simples para pegar os dados do texto)
        // O ideal seria pedir JSON, mas vamos fazer texto simples para não complicar com parsers agora.
        try {
            String[] linhas = respostaDaIA.split("\n");
            for (String linha : linhas) {
                if (linha.contains("Categoria:")) {
                    tarefa.setCategoria(linha.replace("Categoria:", "").trim());
                } else if (linha.contains("Prioridade:")) {
                    tarefa.setPrioridade(linha.replace("Prioridade:", "").trim());
                } else if (linha.contains("Descrição:")) {
                    tarefa.setDescricaoIa(linha.replace("Descrição:", "").trim());
                }
            }
        } catch (Exception e) {
            tarefa.setDescricaoIa("Erro ao processar IA: " + respostaDaIA);
        }

        // 4. Se a IA falhar em algo, colocamos valores padrão
        if (tarefa.getCategoria() == null) tarefa.setCategoria("Geral");
        if (tarefa.getPrioridade() == null) tarefa.setPrioridade("Média");

        // 5. Salvamos no banco
        return repository.save(tarefa);
    }
}