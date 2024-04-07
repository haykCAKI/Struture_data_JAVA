public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = i + 1;
        }

        System.out.println("Conteúdo do array: ");

        for (int num : numeros){
            System.out.print(num + " ");
        }
    }
}
