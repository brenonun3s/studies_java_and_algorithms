package analise_e_ordenacao_de_algoritmos;

// ESSE ALGORITMO ESTÁ SENDO IMPLEMENTADO USANDO A VERSÃO OTIMIZADA EM O(N^2) SOMANDO NO SEGUNDO LAÇO
public class AlgoritmoForcaBruta {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int soma = 0;
            for (int j = i; j < nums.length; j++) {
                soma += nums[j];
                if (soma > max) {
                    max = soma;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 5, -1, 7, -3 };
        System.out.println(maxSubArray(arr));
    }
}
