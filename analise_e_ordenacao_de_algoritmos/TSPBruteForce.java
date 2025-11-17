package analise_e_ordenacao_de_algoritmos;

import java.util.*;

// RESOLVENDO O PROBLEMA DO CAIXEIRO VIAJANTE USANDO A ABORDAGEM DE ALGORITMO DE FORÇA BRUTA

public class TSPBruteForce {

    static Map<String, Integer> dist = new HashMap<>();

    static {
        dist.put("AB", 10);
        dist.put("AC", 15);
        dist.put("AD", 20);
        dist.put("BC", 35);
        dist.put("BD", 25);
        dist.put("CD", 30);
    }

    static int distance(char a, char b) {
        String key = "" + Math.min(a, b) + Math.max(a, b);
        return dist.get(key);
    }

    static int routeDistance(char[] route) {
        int total = 0;
        for (int i = 0; i < route.length - 1; i++) {
            total += distance(route[i], route[i + 1]);
        }
        total += distance(route[route.length - 1], route[0]);
        return total;
    }

    public static void main(String[] args) {
        char[] cities = {'A', 'B', 'C', 'D'};

        List<char[]> permutations = new ArrayList<>();
        permute(cities, 0, permutations);

        int bestDist = Integer.MAX_VALUE;
        char[] bestRoute = null;

        for (char[] perm : permutations) {
            int d = routeDistance(perm);
            if (d < bestDist) {
                bestDist = d;
                bestRoute = perm.clone();
            }
        }

        System.out.println("Melhor rota: " + Arrays.toString(bestRoute));
        System.out.println("Distância: " + bestDist);
    }

    // Gera permutações
    static void permute(char[] arr, int index, List<char[]> results) {
        if (index == arr.length - 1) {
            results.add(arr.clone());
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, results);
            swap(arr, index, i);
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

