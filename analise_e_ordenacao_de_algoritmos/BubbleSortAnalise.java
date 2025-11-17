package analise_e_ordenacao_de_algoritmos;

public class BubbleSortAnalise {
 public static void main(String[] args) {
  int[] vetor = {1,2,3,4,5,6,7,8};
  int comparacoes = 0;
  for (int i = 0; i < vetor.length - 1; i++) {
   for (int j = 0; j < vetor.length - 1 - i; j++) {
    System.out.println("Comparando " + vetor[j] + " e " + vetor[j + 1]);
    comparacoes++;
    if (vetor[j] > vetor[j + 1]) {
     int temp = vetor[j];
     vetor[j] = vetor[j + 1];
     vetor[j + 1] = temp;
    }
   }
  }
  System.out.println("Vetor ordenado:");
  for (int n : vetor) {
   System.out.print(n + " ");
  }
  System.out.println("\nTotal de comparações: " + comparacoes);
 }
}
