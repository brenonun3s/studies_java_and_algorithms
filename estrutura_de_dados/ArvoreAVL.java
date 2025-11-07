
class No {
    int valor;
    No esquerda, direita;
    int altura;

    No(int valor) {
        this.valor = valor;
        altura = 1; // altura inicial
    }
}

public class ArvoreAVL {

    private No raiz;

    // Obtém altura de um nó
    private int altura(No n) {
        if (n == null)
            return 0;
        return n.altura;
    }

    // Calcula o fator de balanceamento (FB)
    private int fatorBalanceamento(No n) {
        if (n == null)
            return 0;
        return altura(n.esquerda) - altura(n.direita);
    }

    // Rotação simples à direita
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        // Rotaciona
        x.direita = y;
        y.esquerda = T2;

        // Atualiza alturas
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x; // nova raiz
    }

    // Rotação simples à esquerda
    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        // Rotaciona
        y.esquerda = x;
        x.direita = T2;

        // Atualiza alturas
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y; // nova raiz
    }

    // Inserção de um valor na árvore AVL
    private No inserir(No no, int valor) {
        // Inserção normal de BST
        if (no == null)
            return new No(valor);

        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else
            return no; // valores iguais não são permitidos

        // Atualiza altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Calcula o fator de balanceamento
        int fb = fatorBalanceamento(no);

        // Casos de desbalanceamento

        // Caso 1: Esquerda-Esquerda (rotação direita)
        if (fb > 1 && valor < no.esquerda.valor)
            return rotacaoDireita(no);

        // Caso 2: Direita-Direita (rotação esquerda)
        if (fb < -1 && valor > no.direita.valor)
            return rotacaoEsquerda(no);

        // Caso 3: Esquerda-Direita (rotação dupla direita)
        if (fb > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso 4: Direita-Esquerda (rotação dupla esquerda)
        if (fb < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no; // nó balanceado
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    // Impressão em ordem (in-order traversal)
    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdem(no.direita);
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();

        int[] valores = {30, 20, 10, 25, 40, 50, 22};
        for (int v : valores) {
            avl.inserir(v);
        }

        System.out.println("Árvore AVL (em ordem):");
        avl.imprimirEmOrdem(); // Deve imprimir os valores em ordem crescente e balanceada
    }
}
