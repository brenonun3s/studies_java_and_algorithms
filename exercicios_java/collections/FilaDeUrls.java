package exercicios_java.collections;

import java.util.Scanner;
import java.util.Stack;

/*
* ENUNCIADO DO EXERCICIO
* Use um Stack para simular o histórico de um navegador. 
* Ao acessar URLs, adicione-as à pilha. Implemente o botão "voltar" para remover a última URL.
*/

public class FilaDeUrls {

    public static void main(String[] args) {

        Stack<String> historico = new Stack<>();
        Scanner sc = new Scanner(System.in);

        boolean continua = true;

        while (continua) {
            System.out.println("Digite a URL (ou digite 0 para voltar, 1 para imprimir, 9 para sair): ");
            String entrada = sc.nextLine();

            if (entrada.equals("1")) {
                if (historico.isEmpty()) {
                    System.out.println("Histórico vazio.");
                } else {
                    System.out.println("Histórico de navegação:");
                    for (String url : historico) {
                        System.out.println(url);
                    }
                }
                continue;
            }

            if (entrada.equals("0")) {
                if (!historico.isEmpty()) {
                    String removida = historico.pop();
                    System.out.println("Voltando… removida: " + removida);
                } else {
                    System.out.println("Nada para voltar.");
                }
                continue;
            }

            if (entrada.equals("9")) {
                continua = false;
                continue;
            }
            historico.push(entrada);
            System.out.println("URL adicionada ao histórico.");
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
