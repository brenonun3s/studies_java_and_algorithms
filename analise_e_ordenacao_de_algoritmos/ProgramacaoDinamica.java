package analise_e_ordenacao_de_algoritmos;

import java.util.HashMap;
import java.util.Map;

public class ProgramacaoDinamica {

 // IMPLEMENTAÇÃO DE DOIS ALGORITMOS PARA RESOLVER FIBBONACCI COM PROGRAMAÇÃO
 // DINÂMICA USANDO AS ESTRATÉGIAS DE TOPDOWN BOTTOM-UP

 // Exemplo: Fibonacci com memoization
 static Map<Integer, Long> memo = new HashMap<>();

 static long fib(int n) {
  if (n <= 1)
   return n;
  if (memo.containsKey(n))
   return memo.get(n);

  long resultado = fib(n - 1) + fib(n - 2);
  memo.put(n, resultado);

  return resultado;
 }

 public static void main(String[] args) {
  System.out.println(fib(50));
 }
}

// Fibonacci com tabulação
class FibonacciTab {
 static long fib(int n) {
  long[] dp = new long[n + 1];
  dp[0] = 0;
  dp[1] = 1;

  for (int i = 2; i <= n; i++) {
   dp[i] = dp[i - 1] + dp[i - 2];
  }

  return dp[n];
 }

 public static void main(String[] args) {
  System.out.println(fib(50));
 }
}
