package analise_e_ordenacao_de_algoritmos;

import java.util.*;

// RESOLVENDO PROBLEMA DA MOCHILA FRACIONARIA COM ALGORITMO GULOSO

class Item {
    double valor;
    double peso;

    public Item(double valor, double peso) {
        this.valor = valor;
        this.peso = peso;
    }
}

public class MochilaFracionaria {

    public static double mochilaFracionaria(List<Item> itens, double capacidade) {
        // Ordena pelo valor/peso (decrescente)
        itens.sort((a, b) -> Double.compare(b.valor / b.peso, a.valor / a.peso));

        double valorTotal = 0;

        for (Item item : itens) {
            if (capacidade == 0) break;

            if (item.peso <= capacidade) {
                // Pega o item inteiro
                valorTotal += item.valor;
                capacidade -= item.peso;
            } else {
                // Pega fração
                double fração = capacidade / item.peso;
                valorTotal += item.valor * fração;
                capacidade = 0;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(60, 10));
        itens.add(new Item(100, 20));
        itens.add(new Item(120, 30));

        double capacidade = 50;

        System.out.println("Valor máximo: " + mochilaFracionaria(itens, capacidade));
    }
}

