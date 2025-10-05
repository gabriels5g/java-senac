## Funcionalidades

- Cadastrar novos livros (título, autor e ano de publicação)  
- Listar todos os livros cadastrados  
- Cadastrar alunos (nome, e-mail e telefone)  
- Listar alunos cadastrados  
- Emprestar livros a alunos  
- Devolver livros emprestados  
- Utilizar vetores fixos para armazenamento dos dados  

---

## Estrutura do Código

O projeto é composto por três classes principais:

### 1. `Livro`
Representa cada livro com seus dados e status de empréstimo.
- Atributos: `titulo`, `autor`, `ano`, `emprestado`, `emprestadoPara`
- Métodos principais:
  - `emprestar(String aluno)`
  - `devolver()`
  - `getStatus()`
  - `toString()`

### 2. `Aluno`
Representa os alunos cadastrados.
- Atributos: `nome`, `email`, `telefone`
- Método principal: `toString()`

### 3. `BibliotecaVirtual`
Classe principal que contém:
- Vetores fixos de `Livro` e `Aluno`
- Menu de interação com o usuário
- Métodos para gerenciar as operações do sistema

---

## Como Executar

### 1. Compilar o código
Abra o terminal na pasta onde o arquivo `.java` está localizado e digite:
```bash
javac BibliotecaVirtual.java
