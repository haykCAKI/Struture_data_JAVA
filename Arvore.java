public class Arvore {

   class Node {
       int valor;
       Node esquerda;
       Node direita;

       public Node(int valor) {
           this.valor = valor;
           esquerda = null;
           direita = null;
       }
   }

   class ArvoreBinaria {
       Node raiz;

       public ArvoreBinaria() {
           raiz = null;
       }

       // Inserção
       public void inserir(int valor) {
           raiz = InserirValores(raiz, valor);
       }

       private Node InserirValores(Node atual, int valor) {
           if (atual == null) {
               return new Node(valor);
           }

           if (valor < atual.valor) {
               atual.esquerda = InserirValores(atual.esquerda, valor);
           } else if (valor > atual.valor) {
               atual.direita = InserirValores(atual.direita, valor);
           }
           return atual;
       }

       // Busca
       public boolean buscar(int valor) {
           return BuscarRecursivo(raiz, valor);
       }

       private boolean BuscarRecursivo(Node atual, int valor) {
           if (atual == null) {
               return false;
           }
           if (valor == atual.valor) {
               return true;
           }

           return valor < atual.valor
                   ? BuscarRecursivo(atual.esquerda, valor)
                   : BuscarRecursivo(atual.direita, valor);
       }

       // Remoção
       public void remover(int valor) {
           raiz = RemoverRecursivo(raiz, valor);
       }

       private Node RemoverRecursivo(Node atual, int valor) {
           if (atual == null) {
               return null;
           }

           if (valor == atual.valor) {
               // Node sem filho
               if (atual.esquerda == null && atual.direita == null) {
                   return null;
               }
               // Node com um filho
               if (atual.esquerda == null) {
                   return atual.direita;
               }
               if (atual.direita == null) {
                   return atual.esquerda;
               }
               // Node com dois filhos
               int maiorValorEsquerda = encontrarMaiorValor(atual.esquerda);
               atual.valor = maiorValorEsquerda;
               atual.esquerda = RemoverRecursivo(atual.esquerda, maiorValorEsquerda);
           } else if (valor < atual.valor) {
               atual.esquerda = RemoverRecursivo(atual.esquerda, valor);
           } else {
               atual.direita = RemoverRecursivo(atual.direita, valor);
           }
           return atual;
       }

       private int encontrarMaiorValor(Node node) {
           while (node.direita != null) {
               node = node.direita;
           }
           return node.valor;
       }
   }

   public static void main(String[] args) {
       // Example usage
       ArvoreBinaria arvore = new ArvoreBinaria();
       arvore.inserir(10);
       arvore.inserir(5);
       arvore.inserir(15);
       arvore.remover(10);
   }
}
