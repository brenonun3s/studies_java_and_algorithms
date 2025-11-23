package exercicios_java.collections;

/*
* ENUNCIADO DO EXERCICIO
* Simule um atendimento de senhas prioritárias usando PriorityQueue. 
* Crie uma classe Senha com prioridade (normal, prioritária) e ordene a fila por prioridade.
*/

public class Senha implements Comparable<Senha> {
 private PrioridadeOrdem ordem;

 public Senha(PrioridadeOrdem ordem) {
  this.ordem = ordem;
 }

 public PrioridadeOrdem getOrdem() {
  return ordem;
 }

 public void setOrdem(PrioridadeOrdem ordem) {
  this.ordem = ordem;
 }

 @Override
 public int compareTo(Senha Outrasenha) {
  int thisPeso = (this.ordem == PrioridadeOrdem.PRIORITARIA) ? 0 : 1;
  int outraPeso = (this.ordem == PrioridadeOrdem.PRIORITARIA) ? 0 : 1;
  return Integer.compare(thisPeso, outraPeso);

 }

 @Override
 public String toString() {
  return "Senha{" + ordem + "}";
 }
}
