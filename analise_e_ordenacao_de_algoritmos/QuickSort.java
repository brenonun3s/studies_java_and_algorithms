package analise_e_ordenacao_de_algoritmos;

public class QuickSort {
 public static void main(String[] args) {

  int[] vetor = new int[10];

  for (int i = 0; i < vetor.length; i++) {
   vetor[i] = (int) Math.floor(Math.random() * vetor.length);
  }

  System.out.print("Desordenado\n");
  for (int i = 0; i < vetor.length; i++) {
   System.out.print(vetor[i] + " ");
  }

  quickSort(vetor, 0, vetor.length - 1);

  System.out.print("\nOrdenado\n");
  for (int i = 0; i < vetor.length; i++) {
   System.out.print(vetor[i] + " ");
  }

 }
 // QUICK SORT - COMPLEXIDADE -> O(n log n) no caso médio e melhor, e O(n²) no pior caso

 static void quickSort(int[] vetor, int esquerda, int direita) {
  if (esquerda < direita) {
   int p = particao(vetor, esquerda, direita);
   quickSort(vetor, esquerda, p);
   quickSort(vetor, p + 1, direita);
  }
 }

 static int particao(int[] vetor, int esquerda, int direita) {
  int meio = (int) (esquerda + direita) / 2;
  int pivo = vetor[meio];
  int i = esquerda - 1;
  int j = direita + 1;
  while (true) {
   do {
    i++;
   } while (vetor[i] < pivo);
   do {
    j--;
   } while (vetor[j] > pivo);
   if (i >= j) {
    return j;
   }
   int aux = vetor[i];
   vetor[i] = vetor[j];
   vetor[j] = aux;
  }
 }
}
