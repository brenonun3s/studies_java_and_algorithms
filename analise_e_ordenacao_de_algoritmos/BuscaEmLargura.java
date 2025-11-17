package analise_e_ordenacao_de_algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura<T> {

 private final Vertice<T> verticeInicial;

 public BuscaEmLargura(Vertice<T> verticeInicial){
  this.verticeInicial = verticeInicial;
 }

 public void atravessar(){
  Queue<Vertice<T>> queue = new LinkedList<>();
  queue.add(verticeInicial);

  while(!queue.isEmpty()){
   Vertice<T> atual = queue.poll();

   if(!atual.isVisitado()){
    atual.setVisitado(true);
    System.out.println(atual);

    queue.addAll(atual.getVizinhos());
   }
  }
 }






 
}
