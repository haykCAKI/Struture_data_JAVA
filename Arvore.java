public class Arvore {

   class Node {
      int valor;
      Node esquerda;
      Node direita;

      public Node(int valor){
         this.valor = valor;
         esquerda = null;
         direita  = null;
      }
   }

   class ArvoreBinaria {
      Node raiz;

      public ArvoreBinaria(){
         raiz = null;
      }

      //Inserção
      private Node InserirValores(Node atual, int valor){
         if(atual == null){
            return new Node(valor);
         }

         if (valor < atual.valor){
            atual.esquerda = InserirValores(atual.esquerda, valor);
         } else if (valor > atual.valor){
            atual.direita = InserirValores(atual.direita, valor);
         }

         return atual;
      };
   }

   public static void main(String[] args) {

   }

}
