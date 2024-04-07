import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//classe que representa o livro
class Livro {
    //node titulo
    private String titulo;
    
    //constructor
    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }


    @Override
    public String toString() {
        return titulo;
    }
}

//classe que representa um grafo de livros
class GrafoDeLivros {

    //grafo Map (Livro => Setado Livro)
    private Map<Livro, Set<Livro>> grafo;


    //constructor do grafo de livros
    public GrafoDeLivros() {
        this.grafo = new HashMap<>();
    }
    
    //Método usado para adicionar uma relação entre um livro e o outro
    public void adicionarRelacao(Livro livro, Livro... recomendacoes) {
        Set<Livro> livrosRecomendados = new HashSet<>();
        for (Livro rec : recomendacoes) {
            livrosRecomendados.add(rec);
        }
        grafo.put(livro, livrosRecomendados);
    }

    //Método usado para usar as recomendações de um livro
    public Set<Livro> obterRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }

    //Método para obter todos os livros no grafo
    public Set<Livro> obterTodosLivros() {
        return grafo.keySet();
    }
}

public class SistemaDeRecomendacao {

    public static void main(String[] args) {
        // criando livros para os grafos
        Livro livro1 = new Livro("Harry Potter: Ordem da Phoenix");
        Livro livro2 = new Livro("World of WarCraft");
        Livro livro3 = new Livro("IT: A coisa");
        Livro livro4 = new Livro("1988: Steven King");
        Livro livro5 = new Livro("Castelo de Cartas");
        Livro livro6 = new Livro("Código da Vinte");
        Livro livro7 = new Livro("Eu sou o número 4");
        Livro livro8 = new Livro("Vikings");
        Livro livro9 = new Livro("O Iluminado");
        Livro livro10 = new Livro("Doutor Sono");

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
    }
}
