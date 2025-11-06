import java.util.*;

public class GrafoNaoDirecionado {
    private final int vertices;
    private final List<List<Integer>> adjacencia;

    public GrafoNaoDirecionado(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    // adiciona conexão em ambos os sentidos
    public void adicionarAresta(int a, int b) {
        adjacencia.get(a).add(b);
        adjacencia.get(b).add(a);
    }

    public boolean possuiCiclo() {
        boolean[] visitado = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visitado[i]) {
                if (dfs(i, visitado, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visitado, int pai) {
        visitado[v] = true;

        for (int vizinho : adjacencia.get(v)) {
            if (!visitado[vizinho]) {
                if (dfs(vizinho, visitado, v))
                    return true;
            } else if (vizinho != pai) {
                return true; // encontrou ciclo
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GrafoNaoDirecionado g2 = new GrafoNaoDirecionado(4);
        g2.adicionarAresta(0, 1);
        g2.adicionarAresta(1, 2);
        g2.adicionarAresta(2, 0); // cria ciclo
        g2.adicionarAresta(2, 3);

        System.out.println("Grafo Não Direcionado tem ciclo? " + g2.possuiCiclo());
    }
}
 