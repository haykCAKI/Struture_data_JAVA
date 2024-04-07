import java.util.ArrayList;
import java.util.LinkedList;

class Grafo {

   private ArrayList<String> nodes;
   private ArrayList<LinkedList<String>> conexoes;

   public Grafo() {
      nodes = new ArrayList<>();
      conexoes = new ArrayList<>();
   };

   public void adicionarNode(String nomedoNode) {

      nodes.add(nomedoNode);
      conexoes.add(new LinkedList<>());

   };

   public void adicionarConexao(String origen, String destino) {

      int indexNodeDeOrigin = nodes.indexOf(origen);
      int indexNodeDestino = nodes.indexOf(destino);

      if (indexNodeDeOrigin != -1 && indexNodeDestino != -1) {
         conexoes.get(indexNodeDeOrigin).add(destino);
         conexoes.get(indexNodeDestino).add(destino);
      }
   };

   public void mostrarConexoesDoGrafo() {
      // aqui estamos mostrando os nós
      for (int i = 0; i < nodes.size(); i++) {
         System.out.println("O nó chamado " + nodes.get(i) + " tem conexões com");

         LinkedList<String> conexoesComNodeAtual = conexoes.get(i);

         // aqui mostramos as conexões de cada nó
         for (int j = 0; j < conexoesComNodeAtual.size(); j++) {
            System.out.println(conexoesComNodeAtual.get(j));

            if (j < conexoesComNodeAtual.size() - 1) {
               System.out.println(", ");
            }
         }
         System.out.println();
      }
      ;
   };
};

public class Grafos {

   public static void main(String[] args) {

      Grafo grafoDeCidades = new Grafo();

      grafoDeCidades.adicionarNode("Curitiba");
      grafoDeCidades.adicionarNode("Florianópoles");
      grafoDeCidades.adicionarNode("São Paulo");
      grafoDeCidades.adicionarNode("São Bento do Sul");

      grafoDeCidades.adicionarConexao("Curitiba", "Florianópoles");
      grafoDeCidades.adicionarConexao("São Paulo", "Curitiba");
      grafoDeCidades.adicionarConexao("São Paulo", "São Bento do Sul");

      grafoDeCidades.mostrarConexoesDoGrafo();

   };
};