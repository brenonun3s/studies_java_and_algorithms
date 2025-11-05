package exercicios_java.collections;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ENUNCIADO DO EXERCICIO
 * Crie um programa que armazene nomes de estudantes em uma ArrayList. 
 * O usuário deve poder adicionar, remover e listar todos os estudantes. Implemente também uma busca por nome.
 */

public class Estudantes {

  public static void main(String[] args) {

    ArrayList<String> listaEstudantes = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    boolean continua = true;

    while (continua) {
      System.out.println("DIGITE UMA OPÇÃO ----- > 1 CADASTRAR ESTUDANTE / 2 EXCLUIR / 3 LISTAR TODOS / 4 BUSCAR POR NOME /  0 - SAIR");
      int opcao = sc.nextInt();
      sc.nextLine();

      switch (opcao) {
        case 1:
          System.out.println("Digite o nome do Estudante: ");
          String estudante = sc.nextLine();
          listaEstudantes.add(estudante);
          System.out.println("Aluno Adicionado com sucesso!");
          break;

        case 2:
          System.out.println("Digite o nome do estudante");
          String estudanteExclusao = sc.nextLine();
          boolean existe = listaEstudantes.contains(estudanteExclusao);

          if (existe == true) {
            listaEstudantes.remove(estudanteExclusao);
            System.out.println("Estudante excluido com sucesso");
          } else {
            System.out.println("Não existe esse estudante");
          }
          break;

        case 3:
          for (String e : listaEstudantes) {
            System.out.println("Estudantes:" + e);

          }
          break;
        case 4:
          System.out.println("Digite o nome do estudante buscado: ");
          String estudanteBuscado = sc.nextLine();
          boolean estudanteExiste = listaEstudantes.contains(estudanteBuscado);

          if (estudanteExiste == true) {
            System.out.println("Estudante identificado");
          } else {
            System.out.println("Não existe esse estudante");
          }
          break;
        case 0:
        continua = false;
          break;
      }
    }

    sc.close();

  }

}
