# 📚 Sistema de Gerenciamento de Biblioteca em Java

Um sistema de console interativo desenvolvido em **Java** aplicando conceitos fundamentais de **Programação Orientada a Objetos (POO)**. O projeto simula a rotina de uma biblioteca, permitindo o gerenciamento de livros, leitores (usuários) e o controle completo de empréstimos e devoluções.

---

## 🚀 Funcionalidades

O sistema é dividido em submenus organizados por áreas:

### 📖 1. Gerenciamento de Livros
- **Cadastrar livro:** Registra novos livros com ID, título, autor, gênero e número de páginas.
- **Remover livro:** Remove um livro do acervo *(com validação: impede a remoção caso o livro esteja emprestado no momento)*.
- **Listar livros disponíveis:** Exibe apenas os livros que estão disponíveis na estante para empréstimo.

### 👤 2. Gerenciamento de Usuários
- **Cadastrar usuário:** Registra leitores com nome, CPF e telefone.
- **Remover usuário:** Cancela o cadastro de um usuário *(com validação: impede a exclusão caso o usuário possua empréstimos ativos pendentes)*.
- **Listar usuários:** Exibe todos os leitores cadastrados no sistema.

### 🤝 3. Gerenciamento de Empréstimos
- **Realizar empréstimo:** Associa um livro disponível a um usuário cadastrado, registrando a data do pedido e a data prevista de devolução.
- **Listar empréstimos ativos:** Mostra todos os livros que estão emprestados no momento e com quais leitores estão.
- **Devolver livro:** Registra a devolução do livro, encerrando o empréstimo ativo e tornando o livro automaticamente disponível novamente no catálogo.

---

## 🧠 Conceitos e Boas Práticas Aplicadas

- **Programação Orientada a Objetos (POO):**
  - **Encapsulamento:** Atributos privados (`private`) protegidos e acessados via métodos *getters*, *setters* e comportamentos de domínio.
  - **Associação / Composição de Objetos:** A classe `Emprestimo` conecta diretamente instâncias de `Livro` e `Usuario`.
  - **Sobrescrita de Métodos (`@Override`):** Uso do `toString()` personalizado para formatação limpa dos objetos no console.
- **Coleções (`ArrayList`):** Armazenamento dinâmico e buscas filtradas em memória.
- **Validações e Regra de Negócio (*Fail Fast*):** Verificações imediatas de existência e disponibilidade antes de prosseguir com operações críticas.
- **Interface de Console com Submenus:** Navegação intuitiva estruturada com loops `while`, `switch-case` aninhados e leitura de dados via `Scanner`.

---

## 📂 Estrutura do Projeto

- `Livro.java`: Modelo que representa o livro e controla seu estado de disponibilidade.
- `Usuario.java`: Modelo que representa o leitor cadastrado na biblioteca.
- `Emprestimo.java`: Modelo que relaciona `Livro` e `Usuario`, controlando as datas e o status do empréstimo.
- `Biblioteca.java`: Classe de serviço responsável pelas listas e por todas as regras de negócio do sistema.
- `Main.java`: Ponto de entrada da aplicação contendo os menus interativos via terminal.

---

## ▶️ Como Executar

1. Clone este repositório:
   `git clone https://github.com/MarcosTalvane/Sistema-de-Biblioteca.git`
2. Abra o projeto na sua IDE de preferência (como **IntelliJ IDEA**, Eclipse ou VS Code).
3. Execute a classe `Main.java`.
