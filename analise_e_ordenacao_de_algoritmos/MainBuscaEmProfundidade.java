package analise_e_ordenacao_de_algoritmos;

import java.util.Arrays;

public class MainBuscaEmProfundidade {

 public static void main(String[] args) {

  Vertice<Integer> v0 = new Vertice<Integer>(0);
  Vertice<Integer> v1 = new Vertice<Integer>(1);
  Vertice<Integer> v2 = new Vertice<Integer>(2);
  Vertice<Integer> v3 = new Vertice<Integer>(3);
  Vertice<Integer> v4 = new Vertice<Integer>(4);
  Vertice<Integer> v5 = new Vertice<Integer>(5);
  Vertice<Integer> v6 = new Vertice<Integer>(6);

  v0.setVizinhos(Arrays.asList(v1, v5, v6));
  v1.setVizinhos(Arrays.asList(v3, v4, v5));
  v4.setVizinhos(Arrays.asList(v2, v6));
  v6.setVizinhos(Arrays.asList(v0));

  BuscaEmProfundidade<Integer> dfs = new BuscaEmProfundidade<>();
  dfs.atravessar(v0);
 }
}