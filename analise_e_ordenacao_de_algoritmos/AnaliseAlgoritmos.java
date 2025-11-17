package analise_e_ordenacao_de_algoritmos;

import java.util.Arrays;
import java.util.Random;

public class AnaliseAlgoritmos {
 public static void main(String[] args) {

  int tamanho = 10000;
  int[] dados = new Random().ints(tamanho, 0, 10000).toArray();
  int[] copia1 = Arrays.copyOf(dados, dados.length);
  int[] copia2 = Arrays.copyOf(dados, dados.length);

  // Bubble Sort
  long inicio = System.nanoTime();
  bubbleSort(copia1);
  long fim = System.nanoTime();
  System.out.println("Bubble Sort: " + (fim - inicio) / 1e6 + " ms");
  
  // Merge Sort
  inicio = System.nanoTime();
  mergeSort(copia2, 0, copia2.length - 1);
  fim = System.nanoTime();
  System.out.println("Merge Sort: " + (fim - inicio) / 1e6 + " ms");
 }

 static void bubbleSort(int[] arr) {
  int n = arr.length;
  for (int i = 0; i < n - 1; i++)
   for (int j = 0; j < n - 1 - i; j++)
    if (arr[j] > arr[j + 1]) {
     int tmp = arr[j];
     arr[j] = arr[j + 1];
     arr[j + 1] = tmp;
    }
 }

 static void mergeSort(int[] arr, int esq, int dir) {
  if (esq < dir) {
   int meio = (esq + dir) / 2;
   mergeSort(arr, esq, meio);
   mergeSort(arr, meio + 1, dir);
   merge(arr, esq, meio, dir);
  }
 }

 static void merge(int[] arr, int esq, int meio, int dir) {
  int n1 = meio - esq + 1;
  int n2 = dir - meio;
  int[] L = new int[n1];
  int[] R = new int[n2];
  for (int i = 0; i < n1; ++i)
   L[i] = arr[esq + i];
  for (int j = 0; j < n2; ++j)
   R[j] = arr[meio + 1 + j];
  int i = 0, j = 0;
  int k = esq;
  while (i < n1 && j < n2) {
   if (L[i] <= R[j])
    arr[k++] = L[i++];
   else
    arr[k++] = R[j++];
  }
  while (i < n1)
   arr[k++] = L[i++];
  while (j < n2)
   arr[k++] = R[j++];
 }
}
