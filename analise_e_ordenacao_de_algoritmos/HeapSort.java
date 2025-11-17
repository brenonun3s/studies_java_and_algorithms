package analise_e_ordenacao_de_algoritmos;

public class HeapSort {

 public static void main(String[] args) {

  int[] vetor = new int[10];

  for (int i = 0; i < vetor.length; i++) {
   vetor[i] = (int) Math.floor(Math.random() * vetor.length);
  }

  System.out.println("Desordenado");
  for (int i = 0; i < vetor.length; i++) {
   System.out.println(vetor[i] + " ");
  }

  // HEAP SORT - COMPLEXIDADE PIOR E MÉDIO CASO - O(n log n)

  int n = vetor.length;

  for (int i = n / 2 - 1; i >= 0; i--) {
   aplicarHeap(vetor, n, i);
  }

  for (int j = n - 1; j > 0; j--) {
   int aux = vetor[0];
   vetor[0] = vetor[j];
   vetor[j] = aux;

   aplicarHeap(vetor, j, 0);
  }

  System.out.println("Ordenado");
  for (int i = 0; i < vetor.length; i++) {
   System.out.println(vetor[i] + " ");
  }

 }

 private static void aplicarHeap(int[] vetor, int n, int i) {
  int raiz = i;
  int esq = 2 * i + 1;
  int dir = 2 * i + 2;

  if (esq < n && vetor[esq] > vetor[raiz]) {
   raiz = esq;
  }
  if (dir < n && vetor[dir] > vetor[raiz]) {
   raiz = dir;
  }

  if (raiz != i) {
   int aux = vetor[i];
   vetor[i] = vetor[raiz];
   vetor[raiz] = aux;

   aplicarHeap(vetor, n, raiz);
  }

 }

}
