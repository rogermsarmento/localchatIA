# LocalChat

Chat local desenvolvido em Java que utiliza modelos de linguagem executados localmente por meio do Ollama.

O projeto faz parte da **FortyTwo Lab** e será desenvolvido de forma incremental, acompanhando a evolução dos conceitos apresentados na disciplina de Programação Orientada a Objetos.

## 🚀 Objetivo

Desenvolver uma aplicação de chat capaz de enviar mensagens para um modelo de linguagem executado localmente e apresentar suas respostas ao usuário.

O projeto será desenvolvido progressivamente, passando pelas seguintes macroetapas:

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

O modelo inicialmente utilizado é:

`llama3.2:3b`

O modelo possui aproximadamente **2 GB** e pode ser baixado pelo Ollama com:

```bash
ollama pull llama3.2:3b
```

Para verificar os modelos disponíveis:

```bash
ollama list
```

> A partir da V0.1.0, o Ollama e o modelo `llama3.2:3b` são necessários para utilizar os recursos de IA do projeto.

## 🛠️ Tecnologias

- Java 17
- Maven
- Gson
- Java HTTP Client
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
```

## 🗺️ Planejamento do projeto

O desenvolvimento do LocalChat será dividido em macroetapas. Cada versão introduzirá novos conceitos e funcionalidades, permitindo acompanhar a evolução do software de forma incremental.

### Macroetapa 1 — Aplicação executada pela IDE

Desenvolvimento inicial do LocalChat utilizando o Apache NetBeans e execução diretamente pela IDE.

- [x] **V0.0.0 — Estrutura inicial**
  - criação do projeto Java com Maven;
  - definição da estrutura de diretórios;
  - configuração inicial do `pom.xml`;
  - execução da aplicação pela IDE.

- [x] **V0.1.0 — Integração com Ollama**
  - integração com a API local do Ollama;
  - uso do modelo `llama3.2:3b`;
  - envio de uma mensagem fixa;
  - recebimento e leitura da resposta JSON.

- [x] **V0.2.0 — Entrada do usuário**
  - leitura de mensagens com `Scanner`;
  - construção dinâmica do JSON com Gson;
  - envio da mensagem digitada pelo usuário;
  - exibição de `Você` e `Assistente`.

- [ ] **V0.3.0 — Chat contínuo**
  - envio de várias mensagens;
  - estrutura de repetição;
  - comando para encerrar a conversa.

- [ ] **V0.4.0 — Histórico e contexto**
  - armazenamento das mensagens;
  - inclusão das mensagens anteriores na requisição;
  - manutenção do contexto da conversa.

- [ ] **V0.5.0 — Modularização**
  - separação das responsabilidades;
  - criação de métodos e classes;
  - redução das responsabilidades da classe principal.

- [ ] **V0.6.0 — Tratamento de erros**
  - tratamento de exceções;
  - falhas de conexão;
  - mensagens de erro amigáveis.

- [ ] **V0.7.0 — Verificação do ambiente**
  - verificar a disponibilidade do Ollama;
  - identificar se o serviço está em execução;
  - tentar iniciar o Ollama quando necessário;
  - verificar a disponibilidade do modelo.

- [ ] **V0.8.0 — Seleção de modelo**
  - identificação dos modelos disponíveis;
  - escolha do modelo pelo usuário;
  - utilização dinâmica do modelo selecionado.

- [ ] **V0.9.0 — Consolidação da versão IDE**
  - revisão das funcionalidades;
  - organização do código;
  - documentação;
  - preparação para execução independente da IDE.

### Macroetapa 2 — Aplicação executada pelo terminal

Preparação do LocalChat para utilização sem a necessidade de executar o projeto diretamente pelo NetBeans.

- [ ] **Empacotamento da aplicação**
  - geração do arquivo executável;
  - configuração das dependências;
  - execução fora da IDE.

- [ ] **Execução pelo terminal**
  - inicialização por linha de comando;
  - testes em diferentes sistemas operacionais;
  - documentação dos comandos de execução.

- [ ] **Distribuição**
  - organização dos arquivos necessários;
  - instruções de instalação;
  - preparação de uma versão distribuível do LocalChat.

### Macroetapa 3 — Interface gráfica com Java Swing

Evolução da aplicação de terminal para uma interface gráfica desktop.

- [ ] **Estrutura da interface**
  - criação da janela principal;
  - campo para digitação de mensagens;
  - área para exibição da conversa.

- [ ] **Integração com o chat**
  - envio de mensagens pela interface;
  - exibição das respostas do modelo;
  - integração da interface com as funcionalidades existentes.

- [ ] **Experiência do usuário**
  - organização visual;
  - botões e componentes;
  - melhorias de usabilidade.

### Macroetapa 4 — Interface gráfica com JavaFX

Evolução da interface gráfica utilizando JavaFX.

- [ ] **Migração para JavaFX**
  - criação da estrutura JavaFX;
  - utilização de cenas e componentes;
  - adaptação das funcionalidades existentes.

- [ ] **Interface moderna**
  - estilização com CSS;
  - melhoria da organização visual;
  - componentes de conversa.

- [ ] **Versão final**
  - integração das funcionalidades;
  - testes;
  - documentação;
  - consolidação do projeto.

## 📌 Versão atual

A versão atual é a **V0.2.0 — Entrada do usuário**.

Nesta versão, o usuário pode digitar uma mensagem pelo terminal da IDE, que é convertida para JSON e enviada à API local do Ollama.

Exemplo:

```text
Digite sua mensagem: O que é encapsulamento?

Você: O que é encapsulamento?
Assistente: Encapsulamento é...
```

Nesta etapa, o programa permite **uma mensagem por execução**. O chat contínuo será implementado na V0.3.0.