import java.util.*;

public class GrafoPonderado {
    private final Map<String, List<Aresta>> grafo = new HashMap<>();

    // Classe interna para representar uma aresta com peso
    static class Aresta {
        String destino;
        int peso;

        Aresta(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Adiciona uma aresta ponderada
    public void adicionarAresta(String origem, String destino, int peso) {
        grafo.putIfAbsent(origem, new ArrayList<>());
        grafo.get(origem).add(new Aresta(destino, peso));
    }

    public void mostrarGrafo() {
        for (String vertice : grafo.keySet()) {
            System.out.print(vertice + " -> ");
            for (Aresta a : grafo.get(vertice)) {
                System.out.print(a.destino + "(" + a.peso + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoPonderado g = new GrafoPonderado();
        g.adicionarAresta("A", "B", 5);
        g.adicionarAresta("A", "C", 2);
        g.adicionarAresta("B", "C", 1);
        g.adicionarAresta("C", "D", 7);

        g.mostrarGrafo();
    }
}
