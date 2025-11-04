import java.util.PriorityQueue;

public class Heap {
 
 /**
  * Classe que representa implementação com Heap usando a estrutura do Java Priority Queue
  * @author: Breno Nunes
 */

 public static void main(String[] args) {

  //HEAP MINIMO COM FILA DE PRIORIDADE
  PriorityQueue<Integer> pq = new PriorityQueue<>();

  pq.add(5);
  pq.add(1);
  pq.add(3);

  System.out.println(pq.poll());
  System.out.println(pq.poll());
  System.out.println(pq.poll());

  System.out.println("**********************");

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a);

  maxHeap.add(5);
  maxHeap.add(1);
  maxHeap.add(3);

  System.out.println(maxHeap.poll());
  System.out.println(maxHeap.poll());
  System.out.println(maxHeap.poll());
 }

}
