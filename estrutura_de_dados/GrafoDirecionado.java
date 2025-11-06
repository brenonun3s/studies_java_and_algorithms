import java.util.*;

public class GrafoDirecionado {
    private final int vertices;
    private final List<List<Integer>> adjacencia;

    public GrafoDirecionado(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino) {
        adjacencia.get(origem).add(destino);
    }

    // Detecta ciclo usando DFS
    public boolean possuiCiclo() {
        boolean[] visitado = new boolean[vertices];
        boolean[] pilha = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (dfs(i, visitado, pilha))
                return true;
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visitado, boolean[] pilha) {
        if (pilha[v]) return true;
        if (visitado[v]) return false;

        visitado[v] = true;
        pilha[v] = true;

        for (int vizinho : adjacencia.get(v)) {
            if (dfs(vizinho, visitado, pilha))
                return true;
        }

        pilha[v] = false;
        return false;
    }

    public static void main(String[] args) {
        GrafoDirecionado g1 = new GrafoDirecionado(3);
        g1.adicionarAresta(0, 1);
        g1.adicionarAresta(1, 2);
        g1.adicionarAresta(2, 0); // cria ciclo

        System.out.println("Grafo Direcionado tem ciclo? " + g1.possuiCiclo());
    }
}
