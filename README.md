## Funcionalidades
- Cadastrar livros com título, autor e ano de publicação  
- Listar livros com informações e situação atual (disponível ou emprestado)  
- Cadastrar alunos com nome, e-mail e telefone  
- Listar alunos cadastrados  
- Emprestar livros para alunos registrados  
- Devolver livros  
- Controle de quantidade máxima de livros e alunos  

---

## Estrutura do Código

### Classe `Livro`
Representa um livro da biblioteca, com informações como:
- `nome`
- `autor`
- `ano`
- `emprestado`
- `alunoEmprestimo`

Contém métodos para:
- Emprestar (`emprestar()`)
- Devolver (`devolver()`)
- Exibir situação (`getSituacao()`)
- Mostrar dados formatados (`toString()`)

---

### Classe `Aluno`
Armazena os dados de um aluno:
- `nome`
- `email`
- `telefone`

Possui o método `toString()` para exibir as informações de forma organizada.

---

### Classe `BibliotecaVirtual`
Classe principal com o método `main` e o **menu interativo**.  
Gerencia os vetores de livros e alunos e implementa as principais ações do sistema.

Principais métodos:
- `cadastrarLivro()`  
- `mostrarLivros()`  
- `cadastrarAluno()`  
- `listarAlunos()`  
- `fazerEmprestimo()`  
- `devolverLivro()`  

---

## Como Executar

1. Salve o código em um arquivo chamado **`BibliotecaVirtual.java`**  
2. Compile no terminal:  
   ```bash
   javac BibliotecaVirtual.java
