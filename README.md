# 🧠 Smart Tasks IA

Sistema de tarefas inteligentes que utiliza IA Generativa (Google Gemini) para categorizar, definir prioridades e sugerir detalhes de execução automaticamente.

## 🛠️ Tecnologias
* **Java 17+** & **Spring Boot 3**
* **Spring AI** (Integração com Google Gemini)
* **Thymeleaf** (Interface Web)
* **Spring Data JPA** & **H2 Database** (Banco de dados em memória)

## ⚙️ Configuração Obrigatória
Antes de rodar, abra o arquivo `src/main/resources/application.properties` e adicione a chave:

```properties
spring.ai.google.genai.api-key=COLE_SUA_CHAVE_DO_GOOGLE_AI_STUDIO_AQUI
spring.ai.google.genai.chat.options.model=gemini-2.5-flash

http://localhost:8080 - Site para Teste

http://localhost:8080/h2-console - SQL
org.h2.Driver
jdbc:h2:mem:testdb
sa
Password:(Vazio)
