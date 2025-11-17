package analise_e_ordenacao_de_algoritmos;

import java.util.LinkedList;
import java.util.List;

public class Vertice<T>{
 private final T dado;
 private boolean visitado;
 private List<Vertice<T>> vizinhos = new LinkedList<>();

 public Vertice(T dado){
  this.dado = dado;
 }


 public T getDado() {
  return dado;
 }


 public boolean isVisitado() {
  return visitado;
 }


 public void setVisitado(boolean visitado) {
  this.visitado = visitado;
 }


 public List<Vertice<T>> getVizinhos() {
  return vizinhos;
 }


 public void setVizinhos(List<Vertice<T>> vizinhos) {
  this.vizinhos = vizinhos;
 }


 @Override
 public String toString() {
  return "Vertice [dado=" + dado + ", visitado=" + visitado + "]";
 }


 

 
}