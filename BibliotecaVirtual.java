import java.util.Scanner;

class Livro {
    String nome;
    String autor;
    int ano;
    boolean emprestado;
    String alunoEmprestimo;

    Livro(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
        this.alunoEmprestimo = "";
    }

    void emprestar(String aluno) {
        if (!emprestado) {
            emprestado = true;
            alunoEmprestimo = aluno;
            System.out.println("Livro emprestado para " + aluno);
        } else {
            System.out.println("Esse livro já está emprestado.");
        }
    }

    void devolver() {
        if (emprestado) {
            emprestado = false;
            alunoEmprestimo = "";
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Esse livro não está emprestado.");
        }
    }

    String getSituacao() {
        if (emprestado) {
            return "Emprestado para " + alunoEmprestimo;
        } else {
            return "Disponível";
        }
    }

    public String toString() {
        return "Título: " + nome + " | Autor: " + autor + " | Ano: " + ano + " | Situação: " + getSituacao();
    }
}

class Aluno {
    String nome;
    String email;
    String telefone;

    Aluno(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String toString() {
        return "Nome: " + nome + " | Email: " + email + " | Telefone: " + telefone;
    }
}

public class BibliotecaVirtual {
    static Scanner entrada = new Scanner(System.in);
    static final int TAM_MAX = 100;

    static Livro[] listaLivros = new Livro[TAM_MAX];
    static Aluno[] listaAlunos = new Aluno[TAM_MAX];
    static int contLivros = 0;
    static int contAlunos = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nBIBLIOTECA VIRTUAL");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Cadastrar Aluno");
            System.out.println("6 - Listar Alunos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            if (opcao == 1) {
                cadastrarLivro();
            } else if (opcao == 2) {
                mostrarLivros();
            } else if (opcao == 3) {
                fazerEmprestimo();
            } else if (opcao == 4) {
                devolverLivro();
            } else if (opcao == 5) {
                cadastrarAluno();
            } else if (opcao == 6) {
                listarAlunos();
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        System.out.println("Programa encerrado.");
    }

    static void cadastrarLivro() {
        if (contLivros >= TAM_MAX) {
            System.out.println("Limite de livros atingido.");
            return;
        }

        System.out.print("Título: ");
        String nome = entrada.nextLine();
        System.out.print("Autor: ");
        String autor = entrada.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(entrada.nextLine());

        listaLivros[contLivros] = new Livro(nome, autor, ano);
        contLivros++;
        System.out.println("Livro cadastrado com sucesso.");
    }

    static void mostrarLivros() {
        if (contLivros == 0) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (int i = 0; i < contLivros; i++) {
            System.out.println(listaLivros[i]);
        }
    }

    static void cadastrarAluno() {
        if (contAlunos >= TAM_MAX) {
            System.out.println("Limite de alunos atingido.");
            return;
        }

        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();
        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();

        listaAlunos[contAlunos] = new Aluno(nome, email, telefone);
        contAlunos++;
        System.out.println("Aluno cadastrado.");
    }

    static void listarAlunos() {
        if (contAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (int i = 0; i < contAlunos; i++) {
            System.out.println(listaAlunos[i]);
        }
    }

    static void fazerEmprestimo() {
        if (contLivros == 0) {
            System.out.println("Não há livros cadastrados.");
            return;
        }

        System.out.print("Título do livro: ");
        String titulo = entrada.nextLine();

        Livro livroAchado = null;
        for (int i = 0; i < contLivros; i++) {
            if (listaLivros[i].nome.equalsIgnoreCase(titulo)) {
                livroAchado = listaLivros[i];
                break;
            }
        }

        if (livroAchado == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        System.out.print("Nome do aluno: ");
        String alunoNome = entrada.nextLine();
        boolean existe = false;

        for (int i = 0; i < contAlunos; i++) {
            if (listaAlunos[i].nome.equalsIgnoreCase(alunoNome)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            livroAchado.emprestar(alunoNome);
        } else {
            System.out.println("Aluno não cadastrado.");
        }
    }

    static void devolverLivro() {
        System.out.print("Título do livro para devolver: ");
        String titulo = entrada.nextLine();

        for (int i = 0; i < contLivros; i++) {
            if (listaLivros[i].nome.equalsIgnoreCase(titulo)) {
                listaLivros[i].devolver();
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }
}
