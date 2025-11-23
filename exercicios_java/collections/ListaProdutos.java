package exercicios_java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* ENUNCIADO DO EXERCICIO
*Crie uma classe Produto (com nome e preço). 
*Armazene objetos Produto em um ArrayList e ordene a lista por preço usando Collections.sort() com Comparator.
*/

public class ListaProdutos {

 public static void main(String[] args) {

  Produto p1 = new Produto("Celular", 1500.0);
  Produto p2 = new Produto("TV", 1000);
  Produto p3 = new Produto("Cama", 500);
  Produto p4 = new Produto("Maça", 10);
  Produto p5 = new Produto("Teclado", 50);

  ArrayList<Produto> produtos = new ArrayList<>();
  produtos.add(p1);
  produtos.add(p2);
  produtos.add(p3);
  produtos.add(p4);
  produtos.add(p5);

  Collections.sort(produtos,Comparator.comparing(Produto::getPreço));
  System.out.println("Produtos ordenados" + produtos);
  
 }
 
}
