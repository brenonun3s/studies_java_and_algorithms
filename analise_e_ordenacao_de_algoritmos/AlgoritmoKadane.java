package analise_e_ordenacao_de_algoritmos;

public class AlgoritmoKadane {

 public static int maxSubArray(int[] nums) {
  int somaAtual = 0;
  int somaMaxima = Integer.MIN_VALUE;

  for (int n : nums) {
   somaAtual += n;

   if (somaAtual > somaMaxima) {
    somaMaxima = somaAtual;
   }

   if (somaAtual < 0) {
    somaAtual = 0; 
   }
  }

  return somaMaxima;
 }

 public static void main(String[] args) {
  int[] arr = { -2, 5, -1, 7, -3 };
  System.out.println(maxSubArray(arr)); // 11
 }
}
