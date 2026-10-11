# LocalChat

Chat local desenvolvido em Java que utiliza modelos de linguagem executados localmente por meio do Ollama.

O projeto faz parte da **FortyTwo Lab** e será desenvolvido de forma incremental, acompanhando a evolução dos conceitos apresentados na disciplina de Programação Orientada a Objetos.

## 🚀 Objetivo

Desenvolver uma aplicação de chat capaz de enviar mensagens para um modelo de linguagem executado localmente e apresentar suas respostas ao usuário.

O projeto será desenvolvido progressivamente, passando pelas seguintes etapas:

1. aplicação executada pela IDE;
2. aplicação executada pelo terminal;
3. interface gráfica com Java Swing;
4. interface gráfica com JavaFX.

## 📋 Requisitos

Para acompanhar o desenvolvimento do projeto, recomenda-se:

- **Java JDK 17** ou superior;
- **Apache NetBeans** com suporte a projetos Maven;
- **Apache Maven**;
- **Git**;
- **Ollama**;
- aproximadamente **4 GB de espaço livre em disco**, considerando o projeto, ferramentas e o modelo de linguagem.

### Modelo de linguagem

O modelo inicialmente utilizado será:

`llama3.2:3b`

O modelo possui aproximadamente **2 GB** e deverá ser baixado pelo Ollama nas versões do projeto que utilizarem IA.

> Nesta versão inicial (V0.0.0), o Ollama e o modelo ainda não são necessários para executar o código. Eles serão utilizados nas próximas versões.

## 🛠️ Tecnologias

- Java 17
- Maven
- Ollama
- Git e GitHub
- Java Swing
- JavaFX

## 💻 Sistemas operacionais

O projeto está sendo desenvolvido para ser executado em:

- macOS;
- Windows;
- Linux.

O código-fonte Java e a configuração Maven são independentes do sistema operacional.

## 📁 Estrutura do projeto

```text
LocalChat/
├── src/          # Código-fonte Java
├── resources/    # Imagens, ícones e outros recursos
├── docs/         # Documentação do projeto
├── support/      # Materiais de apoio
├── pom.xml       # Configuração Maven
└── README.md