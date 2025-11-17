package analise_e_ordenacao_de_algoritmos;

import java.util.*;

class Intervalo {
    int inicio;
    int fim;

    public Intervalo(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
}

public class EscalonamentoIntervalos {

    public static int maxIntervalos(List<Intervalo> intervalos) {

        // 1. Ordenar pelo horário de fim
        intervalos.sort(Comparator.comparingInt(i -> i.fim));

        int count = 0;
        int fimAtual = -1;

        // 2. Percorrer escolhendo sempre o primeiro intervalo que não se sobrepõe
        for (Intervalo intervalo : intervalos) {
            if (intervalo.inicio >= fimAtual) { 
                count++;
                fimAtual = intervalo.fim; // Atualiza o "último fim"
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Intervalo> intervalos = Arrays.asList(
                new Intervalo(1, 4),
                new Intervalo(3, 5),
                new Intervalo(0, 6),
                new Intervalo(5, 7),
                new Intervalo(8, 9)
        );

        int resultado = maxIntervalos(intervalos);
        System.out.println("Máximo de intervalos não sobrepostos: " + resultado);
    }
}
