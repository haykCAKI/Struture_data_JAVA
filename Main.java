public class Main {

   static class Node {
       int valor;
       Node esquerda;
       Node direita;

       public Node(int valor) {
           this.valor = valor;
           esquerda = null;
           direita = null;
       }
   }

    static class ArvoreBinaria {
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
       };

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
               int maiorValor = BuscaMaiorValor(atual.esquerda);
               atual.valor = maiorValor;
               atual.esquerda = RemoverRecursivo(atual.esquerda, maiorValor);
               return atual;
           }

           if (valor < atual.valor) {
               atual.esquerda = RemoverRecursivo(atual.esquerda, valor);
               return atual;
           }

           atual.direita = RemoverRecursivo(atual.direita, valor);
           return atual;
       };

       private int BuscaMaiorValor(Node raiz) {
           return raiz.direita == null ? raiz.valor : BuscaMaiorValor(raiz.direita);
       }

       // Mostrar árvore em preordem
       public void mostrar() {
           mostrarRecursivo(raiz, 0);
       }

       private void mostrarRecursivo(Node atual, int nivel) {
           if (atual != null) {
               if (nivel > 0){
                  for (int i = 0; i < nivel - 1; i++) {
                     System.out.print("     ");
                 }
                 System.out.print("└----");
               }

               System.out.println(atual.valor);
               // Para cada nível, aumentamos o nível para os nós filhos
               mostrarRecursivo(atual.esquerda, nivel + 1);
               mostrarRecursivo(atual.direita, nivel + 1);
           }
       }
   }

 
   public static void main(String[] args) {
       ArvoreBinaria louvor = new ArvoreBinaria();

       // inserindo a raiz
       louvor.inserir(20);

       // inserindo alguns filhos da raiz
       louvor.inserir(25);
       louvor.inserir(10);

       // inserindo mais alguns nós
       louvor.inserir(8);
       louvor.inserir(30);
       louvor.inserir(22);

       // finalizando com mais dois nós
       louvor.inserir(35);
       louvor.inserir(23);

       System.out.println(louvor.buscar(25)); // true
       System.out.println(louvor.buscar(70)); // false

       System.out.println("Árvore antes da remoção: ");
       louvor.mostrar();

       louvor.remover(25);
       System.out.println(louvor.buscar(25)); // false

       System.out.println("Árvore depois da remoção: ");
       louvor.mostrar();

   }

}
