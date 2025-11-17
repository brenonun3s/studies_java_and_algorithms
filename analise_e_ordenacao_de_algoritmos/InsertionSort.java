package analise_e_ordenacao_de_algoritmos;

public class InsertionSort {
 
 public static void main(String[] args) {
  int[] vetor = new int[10];

  
  for (int i = 0; i < vetor.length; i++) {
   vetor[i] = (int) (Math.random() * vetor.length);
   System.out.println(vetor[i]);

  }


   /* INSERTION SORT
   
   COMPLEXIDADE: O(N^2)
   
   */ 
  int aux;
  int j;
  for (int i =  1; i < vetor.length; i++) {
   aux = vetor[i];
   j = i -1;
   while (j >= 0 && vetor[j] > aux ) {
    vetor[j + 1] =  vetor[j];
    j--;
   }
   vetor[j+1] = aux;
  }

  System.out.println("\n VETOR ORDENADO COM INSERTION SORT");
  for (int i = 0; i < vetor.length; i++) {
   System.out.println(vetor[i]);
  }

 }

}
