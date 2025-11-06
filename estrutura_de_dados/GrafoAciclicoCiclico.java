import java.util.ArrayList;
import java.util.List;

public class GrafoAciclicoCiclico {
    private final int vertices;
    private final List<List<Integer>> adjacencia;

    // Construtor
    public GrafoAciclicoCiclico(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    // Adiciona uma aresta direcionada
    public void adicionarAresta(int origem, int destino) {
        adjacencia.get(origem).add(destino);
    }

    // Método para detectar ciclo usando DFS
    public boolean possuiCiclo() {
        boolean[] visitado = new boolean[vertices];
        boolean[] pilhaRecursao = new boolean[vertices]; // rastreia vértices no caminho atual

        for (int i = 0; i < vertices; i++) {
            if (detectarCicloDFS(i, visitado, pilhaRecursao))
                return true;
        }
        return false;
    }

    // DFS recursivo para detectar ciclo
    private boolean detectarCicloDFS(int v, boolean[] visitado, boolean[] pilhaRecursao) {
        if (pilhaRecursao[v]) return true;
        if (visitado[v]) return false;

        visitado[v] = true;
        pilhaRecursao[v] = true;

        for (int vizinho : adjacencia.get(v)) {
            if (detectarCicloDFS(vizinho, visitado, pilhaRecursao))
                return true;
        }

        pilhaRecursao[v] = false;
        return false;
    }

    public static void main(String[] args) {
        // Exemplo 1: Grafo com ciclo
        GrafoAciclicoCiclico grafoCiclico = new GrafoAciclicoCiclico(3);
        grafoCiclico.adicionarAresta(0, 1);
        grafoCiclico.adicionarAresta(1, 2);
        grafoCiclico.adicionarAresta(2, 0); // ciclo

        System.out.println("Grafo 1 é cíclico? " + grafoCiclico.possuiCiclo());

        // Exemplo 2: Grafo acíclico
        GrafoAciclicoCiclico grafoAciclico = new GrafoAciclicoCiclico(3);
        grafoAciclico.adicionarAresta(0, 1);
        grafoAciclico.adicionarAresta(1, 2);

        System.out.println("Grafo 2 é cíclico? " + grafoAciclico.possuiCiclo());
    }
}


