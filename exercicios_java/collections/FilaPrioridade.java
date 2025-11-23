package exercicios_java.collections;

import java.util.PriorityQueue;

/*
* ENUNCIADO DO EXERCICIO
* Simule um atendimento de senhas prioritárias usando PriorityQueue. 
* Crie uma classe Senha com prioridade (normal, prioritária) e ordene a fila por prioridade.
*/


public class FilaPrioridade {

 public static void main(String[] args) {

 
  Senha senha1 = new Senha(PrioridadeOrdem.NORMAL);
  Senha senha3 = new Senha(PrioridadeOrdem.NORMAL);
  Senha senha4 = new Senha(PrioridadeOrdem.NORMAL);
  Senha senha5 = new Senha(PrioridadeOrdem.NORMAL);
  Senha senha2 = new Senha(PrioridadeOrdem.PRIORITARIA);
  Senha senha6 = new Senha(PrioridadeOrdem.PRIORITARIA);
  Senha senha7 = new Senha(PrioridadeOrdem.PRIORITARIA);
  Senha senha8 = new Senha(PrioridadeOrdem.PRIORITARIA);

  PriorityQueue<Senha> fila = new PriorityQueue<>();
  fila.add(senha2);
  fila.add(senha1);
  fila.add(senha3);
  fila.add(senha4);
  fila.add(senha5);
  fila.add(senha6);
  fila.add(senha7);
  fila.add(senha8);

while (!fila.isEmpty()) {
 System.out.println(fila.poll());
};

  
  



 }
 
}
