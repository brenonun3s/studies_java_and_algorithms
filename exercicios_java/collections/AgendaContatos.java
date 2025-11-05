package exercicios_java.collections;

import java.util.HashMap;
import java.util.Scanner;

/*
 * ENUNCIADO DO EXERCICIO
 * Use um HashMap para criar uma agenda de contatos (nome → telefone). 
 * Implemente funções para adicionar, remover, buscar e listar contatos.
 */

public class AgendaContatos {
 public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);

  HashMap<String, String> agenda = new HashMap<>();

  boolean continua = true;

  while (continua) {
   System.out
     .println("Digite uma opção: 1 - ADICIONAR / 2 - REMOVER / 3 - BUSCAR CONTATO / 4 - LISTAR TODOS / 0 - SAIR");

   int opcao = sc.nextInt();
   sc.nextLine();
   switch (opcao) {
    case 1:
     System.out.println("Digite o telefone para armazenar na agenda: ");
     String telefone = sc.nextLine();

     System.out.println("Digite o nome da pessoa que pertence a esse contato:");
     String pessoa = sc.nextLine();
     agenda.put(pessoa, telefone);
     System.out.println("Pessoa adicionada com sucesso");
     break;
    case 2:
     System.out.println("Digite o nome da pessoa que deseja remover da agenda:");
     String pessoaExcluir = sc.nextLine();
     if (agenda.get(pessoaExcluir) != null) {
      agenda.remove(pessoaExcluir);
      System.out.println("Pessoa removida da lista com sucesso!");
     } else {
      System.out.println("Esssa pessoa não está na lista");
     }
     break;

    case 3:
     System.out.println("Digite o nome do contato que deseja buscar: ");
     String pessoaBuscada = sc.nextLine();
     if (agenda.containsKey(pessoaBuscada)) {
      System.out.println("Pessoa encontrada" + agenda.get(pessoaBuscada));
     } else {
      System.out.println("Esssa pessoa não está na lista");
     }
     break;

    case 4:
     System.out.println("Pessoas da lista : " + agenda.keySet());
     break;
    case 0:
     continua = false;

     break;
   }

  }
  sc.close();
 }
}
