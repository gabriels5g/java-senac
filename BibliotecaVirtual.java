import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    int ano;
    boolean emprestado = false;
    String emprestadoPara = null;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public void emprestar(String aluno) {
        if (!emprestado) {
            emprestado = true;
            emprestadoPara = aluno;
            System.out.println("Livro emprestado para " + aluno + ".");
        } else {
            System.out.println("Livro já está emprestado!");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
            emprestadoPara = null;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }

    public String getStatus() {
        return emprestado ? "Emprestado para " + emprestadoPara : "Disponível";
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Ano: %d | Status: %s",
                titulo, autor, ano, getStatus());
    }
}

class Aluno {
    String nome;
    String email;
    String telefone;

    public Aluno(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | E-mail: %s | Telefone: %s",
                nome, email, telefone);
    }
}

public class BibliotecaVirtual {
    static Scanner sc = new Scanner(System.in);
    static final int MAX_LIVROS = 100;
    static final int MAX_ALUNOS = 100;
    static Livro[] livros = new Livro[MAX_LIVROS];
    static Aluno[] alunos = new Aluno[MAX_ALUNOS];
    static int totalLivros = 0;
    static int totalAlunos = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("BIBLIOTECA VIRTUAL");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Cadastrar Aluno");
            System.out.println("6. Listar Alunos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> adicionarLivro();
                case 2 -> listarLivros();
                case 3 -> emprestarLivro();
                case 4 -> devolverLivro();
                case 5 -> cadastrarAluno();
                case 6 -> listarAlunos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void adicionarLivro() {
        if (totalLivros >= MAX_LIVROS) {
            System.out.println("Limite máximo de livros atingido!");
            return;
        }
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o autor: ");
        String autor = sc.nextLine();
        System.out.print("Digite o ano de publicação: ");
        int ano = Integer.parseInt(sc.nextLine());
        livros[totalLivros] = new Livro(titulo, autor, ano);
        totalLivros++;
        System.out.println("Livro adicionado com sucesso!");
    }

    static void listarLivros() {
        if (totalLivros == 0) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (int i = 0; i < totalLivros; i++) {
                System.out.println(livros[i]);
            }
        }
    }

    static void cadastrarAluno() {
        if (totalAlunos >= MAX_ALUNOS) {
            System.out.println("Limite máximo de alunos atingido!");
            return;
        }
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.print("Digite o e-mail: ");
        String email = sc.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = sc.nextLine();
        alunos[totalAlunos] = new Aluno(nome, email, telefone);
        totalAlunos++;
        System.out.println("Aluno cadastrado com sucesso!");
    }

    static void listarAlunos() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (int i = 0; i < totalAlunos; i++) {
                System.out.println(alunos[i]);
            }
        }
    }

    static void emprestarLivro() {
        if (totalLivros == 0) {
            System.out.println("Nenhum livro disponível.");
            return;
        }
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        Livro livroEncontrado = null;
        for (int i = 0; i < totalLivros; i++) {
            if (livros[i].titulo.equalsIgnoreCase(titulo)) {
                livroEncontrado = livros[i];
                break;
            }
        }
        if (livroEncontrado == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro!");
            return;
        }
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();
        boolean alunoExiste = false;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].nome.equalsIgnoreCase(nomeAluno)) {
                alunoExiste = true;
                break;
            }
        }
        if (alunoExiste) {
            livroEncontrado.emprestar(nomeAluno);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    static void devolverLivro() {
        System.out.print("Digite o título do livro para devolver: ");
        String titulo = sc.nextLine();
        for (int i = 0; i < totalLivros; i++) {
            if (livros[i].titulo.equalsIgnoreCase(titulo)) {
                livros[i].devolver();
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }
}
