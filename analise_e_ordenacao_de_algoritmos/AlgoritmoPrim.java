package analise_e_ordenacao_de_algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Classe que representa uma aresta
class Aresta {
    int destino;
    int peso;

    public Aresta(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Classe que representa o grafo
class Grafo {
    int V; // número de vértices
    List<List<Aresta>> adj; // lista de adjacência

    public Grafo(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Adiciona uma aresta não-direcionada (grafo não direcionado)
    public void adicionarAresta(int origem, int destino, int peso) {
        adj.get(origem).add(new Aresta(destino, peso));
        adj.get(destino).add(new Aresta(origem, peso));
    }

    // Executa o algoritmo de Prim a partir de um vértice inicial
    public void prim(int inicio) {
        // Array para armazenar o menor peso de conexão de cada vértice
        int[] key = new int[V];
        // Array para armazenar o pai de cada vértice na MST
        int[] parent = new int[V];
        // Booleano para marcar vértices já incluídos na MST
        boolean[] incluido = new boolean[V];

        // Inicialização
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Começa pelo vértice inicial
        key[inicio] = 0;

        // Fila de prioridade (min-heap) para pegar o vértice com menor chave
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{inicio, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            if (incluido[u]) continue; // evita reprocessar vértices já na MST
            incluido[u] = true;

            // Para cada vizinho v de u
            for (Aresta vizinho : adj.get(u)) {
                int v = vizinho.destino;
                int peso = vizinho.peso;

                // Se v ainda não está na MST e o peso da aresta (u,v) é menor que a chave atual
                if (!incluido[v] && peso < key[v]) {
                    key[v] = peso;
                    parent[v] = u;
                    pq.offer(new int[]{v, key[v]});
                }
            }
        }

        // Exibe as arestas da MST
        System.out.println("Arestas da Árvore Geradora Mínima (Prim):");
        int pesoTotal = 0;
        for (int i = 0; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + "  (peso: " + key[i] + ")");
                pesoTotal += key[i];
            }
        }
        System.out.println("Peso total da MST: " + pesoTotal);
    }
}

// Classe principal
public class AlgoritmoPrim {
    public static void main(String[] args) {
        // Exemplo de grafo
        int V = 5;
        Grafo g = new Grafo(V);

        // Adicionando arestas (grafo não direcionado)
        g.adicionarAresta(0, 1, 2);
        g.adicionarAresta(0, 3, 6);
        g.adicionarAresta(1, 2, 3);
        g.adicionarAresta(1, 3, 8);
        g.adicionarAresta(1, 4, 5);
        g.adicionarAresta(2, 4, 7);
        g.adicionarAresta(3, 4, 9);

        // Executando o algoritmo a partir do vértice 0
        g.prim(0);
    }
}
