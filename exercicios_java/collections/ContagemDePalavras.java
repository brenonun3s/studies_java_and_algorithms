package exercicios_java.collections;

import java.util.HashSet;
import java.util.Scanner;

/*
 * ENUNCIADO DO EXERCICIO
 * Receba uma frase como input, separe as palavras e armazene-as em um HashSet para obter apenas palavras únicas. 
 * Exiba o total de palavras únicas
 * 
 */

public class ContagemDePalavras {
 
 public static void main(String[] args) {
   
  Scanner sc = new Scanner(System.in);

  System.out.println("Digite sua frase: ");
  String frase = sc.nextLine();

  String minusculo = frase.toLowerCase();
  String palavras[] = minusculo.split(" ");

  HashSet<String> hash = new HashSet<>();

  for (int i = 0; i < palavras.length; i++) {
   hash.add(palavras[i]);

  }

  for (String elementos : hash) {
   System.out.println(elementos);
   
  }
  System.out.println(hash.size());

  sc.close();
 }

 

}
