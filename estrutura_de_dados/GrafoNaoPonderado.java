import java.util.*;

public class GrafoNaoPonderado {
    private final Map<String, List<String>> grafo = new HashMap<>();

    // Adiciona uma aresta (ligação) entre dois vértices
    public void adicionarAresta(String origem, String destino) {
        grafo.putIfAbsent(origem, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());

        // Como é não direcionado, adiciona nos dois sentidos
        grafo.get(origem).add(destino);
        grafo.get(destino).add(origem);
    }

    // Mostra todas as conexões
    public void mostrarGrafo() {
        for (String vertice : grafo.keySet()) {
            System.out.println(vertice + " -> " + grafo.get(vertice));
        }
    }

    public static void main(String[] args) {
        GrafoNaoPonderado g = new GrafoNaoPonderado();
        g.adicionarAresta("A", "B");
        g.adicionarAresta("A", "C");
        g.adicionarAresta("B", "D");
        g.adicionarAresta("C", "D");

        g.mostrarGrafo();
    }
}
