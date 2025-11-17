package analise_e_ordenacao_de_algoritmos;

import java.util.Random;

public class MergeSort {
 public static void main(String[] args) {

  // FOI UTILIZADO A CLASSE RANDOM PARA GERAR O NÚMEROS ALEATÓRIOS DO VETOR

  Random rand = new Random();
  int[] vetor = new int[10];

  for (int i = 0; i < vetor.length; i++) {
   vetor[i] = rand.nextInt(1000);
  }

  System.out.println("Antes:");
  imprimirArray(vetor);

  mergeSort(vetor);

  System.out.println("\nDepois:");
  imprimirArray(vetor);
 }


 // ALGORITMO MERGESORT - COMPLEXIDADE O(n log n) -> TEMPO

 private static void mergeSort(int[] vetor) {
  int tamanhoVetor = vetor.length;

  if (tamanhoVetor < 2) {
   return;
  }

  int meio = tamanhoVetor / 2;
  int[] metadeEsquerda = new int[meio];
  int[] metadeDireita = new int[tamanhoVetor - meio];

  for (int i = 0; i < meio; i++) {
   metadeEsquerda[i] = vetor[i];
  }
  for (int i = meio; i < tamanhoVetor; i++) {
   metadeDireita[i - meio] = vetor[i];
  }

  mergeSort(metadeEsquerda);
  mergeSort(metadeDireita);

  merge(vetor, metadeEsquerda, metadeDireita);
 }

 private static void merge(int[] vetor, int[] metadeEsquerda, int[] metadeDireita) {
  int tamanhoEsquerda = metadeEsquerda.length;
  int tamanhoDireita = metadeDireita.length;

  int i = 0, j = 0, k = 0;

  while (i < tamanhoEsquerda && j < tamanhoDireita) {
   if (metadeEsquerda[i] <= metadeDireita[j]) {
    vetor[k] = metadeEsquerda[i];
    i++;
   } else {
    vetor[k] = metadeDireita[j];
    j++;
   }
   k++;
  }

  while (i < tamanhoEsquerda) {
   vetor[k] = metadeEsquerda[i];
   i++;
   k++;
  }

  while (j < tamanhoDireita) {
   vetor[k] = metadeDireita[j];
   j++;
   k++;
  }

 }

 private static void imprimirArray(int[] vetor) {
  for (int i = 0; i < vetor.length; i++) {
   System.out.println(vetor[i]);
  }
 }
}
