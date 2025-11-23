package exercicios_java.collections;

/*
* ENUNCIADO DO EXERCICIO
*Crie uma classe Produto (com nome e preço). 
*Armazene objetos Produto em um ArrayList e ordene a lista por preço usando Collections.sort() com Comparator.
*/

public class Produto {
 private String nome;
 private double preço;

 



 public String getNome() {
  return nome;
 }


 public void setNome(String nome) {
  this.nome = nome;
 }


 public double getPreço() {
  return preço;
 }


 public void setPreço(double preço) {
  this.preço = preço;
 }


 public Produto(String nome, double preço) {
  this.nome = nome;
  this.preço = preço;
 }

 @Override
 public String toString() {
  return "Produto [nome=" + nome + ", preço=" + preço + "]";
 }

 
}
