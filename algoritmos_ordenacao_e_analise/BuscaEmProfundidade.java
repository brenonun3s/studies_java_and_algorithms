package algoritmos_ordenacao_e_analise;

import java.util.Deque;
import java.util.LinkedList;

// IMPLEMENTAÇÃO NÃO SERVE EM GRAFOS COM CICLOS
public class BuscaEmProfundidade<T> {
 

 public void atravessar(Vertice<T> verticeInicial){
  Deque<Vertice<T>> pilha = new LinkedList<>();
  pilha.push(verticeInicial);

  while (!pilha.isEmpty()) {
   Vertice<T> atual =  pilha.pop();
   if (!atual.isVisitado()) {
    atual.setVisitado(true);
    System.out.println(atual);

    atual.getVizinhos().forEach(pilha::push);
    
   }
   
  }
 }

}
