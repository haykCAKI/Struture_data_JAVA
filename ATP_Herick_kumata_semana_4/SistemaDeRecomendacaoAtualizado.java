//Trabalho Feito pelo Herick Akio Yoshii Kumata PUCPR-EAD Analise e Desenvolvimento de Sistemas
//matéria de Métodos de Pesquisa e Ordenação em Estruturas de Dados (11100010561_20241_01)
import java.util.*;

// Classe que representa o livro
class Livro {
    private String titulo;
    private int ano;
    private String autor;

    public Livro(String titulo, int ano, String autor) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return titulo;
    }
}

// Classe que representa um grafo de livros
class GrafoDeLivros {
    private Map<Livro, Set<Livro>> grafo;

    public GrafoDeLivros() {
        this.grafo = new HashMap<>();
    }

    public void adicionarRelacao(Livro livro, Livro... recomendacoes) {
        Set<Livro> livrosRecomendados = new HashSet<>();
        for (Livro rec : recomendacoes) {
            livrosRecomendados.add(rec);
        }
        grafo.put(livro, livrosRecomendados);
    }

    public Set<Livro> obterRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }

    public Set<Livro> obterTodosLivros() {
        return grafo.keySet();
    }
}

public class SistemaDeRecomendacaoAtualizado {
    public static void main(String[] args) {
        // Criando livros para os grafos
        Livro livro1 = new Livro("Harry Potter: Ordem da Phoenix", 2003, "J.K. Rowling");
        Livro livro2 = new Livro("World of WarCraft", 2004, "Chris Metzen");
        Livro livro3 = new Livro("IT: A coisa", 1986, "Stephen King");
        Livro livro4 = new Livro("1988: Steven King", 1988, "Stephen King");
        Livro livro5 = new Livro("Castelo de Cartas", 1987, "Michael Dobbs");
        Livro livro6 = new Livro("Código da Vinte", 2003, "Dan Brown");
        Livro livro7 = new Livro("Eu sou o número 4", 2010, "Pittacus Lore");
        Livro livro8 = new Livro("Vikings", 1951, "Johan Theorin");
        Livro livro9 = new Livro("O Iluminado", 1977, "Stephen King");
        Livro livro10 = new Livro("Doutor Sono", 2013, "Stephen King");

        // Criar o grafo de livros e adicionar relações
        GrafoDeLivros grafo = new GrafoDeLivros();
        grafo.adicionarRelacao(livro1, livro4, livro5);
        grafo.adicionarRelacao(livro2, livro8, livro7);
        grafo.adicionarRelacao(livro3, livro6);
        grafo.adicionarRelacao(livro4, livro7);
        grafo.adicionarRelacao(livro5, livro8);
        grafo.adicionarRelacao(livro6, livro9);
        grafo.adicionarRelacao(livro7, livro10);
        grafo.adicionarRelacao(livro8, livro9, livro10);
        grafo.adicionarRelacao(livro9, livro10);

        // Exemplo de uso: obter recomendações para um livro específico
        for (Livro livro : grafo.obterTodosLivros()) {
            Set<Livro> recomendacoes = grafo.obterRecomendacoes(livro);
            System.out.println("Recomendações para " + livro.getTitulo() + ": " + recomendacoes);
        }

        // Adicionando uma pilha de livros
        Stack<Livro> pilhaDeLivros = new Stack<>();
        pilhaDeLivros.push(livro1);
        pilhaDeLivros.push(livro2);
        pilhaDeLivros.push(livro3);

        System.out.println("Pilha de livros:");
        while (!pilhaDeLivros.isEmpty()) {
            System.out.println(pilhaDeLivros.pop());
        }

        // Adicionando uma lista de livros
        List<Livro> listaDeLivros = new LinkedList<>();
        listaDeLivros.add(livro4);
        listaDeLivros.add(livro5);
        listaDeLivros.add(livro6);

        System.out.println("Lista de livros:");
        for (Livro livro : listaDeLivros) {
            System.out.println(livro);
        }
    }
}
