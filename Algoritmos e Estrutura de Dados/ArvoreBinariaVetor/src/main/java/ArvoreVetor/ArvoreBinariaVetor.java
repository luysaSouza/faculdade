package ArvoreVetor;

public class ArvoreBinariaVetor {
    private int[] arvore;
    private int tamanho;

    public ArvoreBinariaVetor(int capacidade) {
        arvore = new int[capacidade];
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho >= arvore.length) {
            throw new RuntimeException("A árvore está cheia.");
        }
        arvore[tamanho++] = valor;
    }

    public void exibir() {
        System.out.println("Elementos da árvore (em nível):");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(arvore[i] + " ");
        }
        System.out.println();
    }

    public void exibirEstrutura() {
        System.out.println("\nEstrutura da árvore:");
        for (int i = 0; i < tamanho; i++) {
            int valor = arvore[i];
            int esq = 2 * i + 1;
            int dir = 2 * i + 2;

            System.out.print("Nó: " + valor);
            if (esq < tamanho) {
                System.out.print(" | Esquerda: " + arvore[esq]);
            } else {
                System.out.print(" | Esquerda: -");
            }

            if (dir < tamanho) {
                System.out.print(" | Direita: " + arvore[dir]);
            } else {
                System.out.print(" | Direita: -");
            }
            System.out.println();
        }
    }
}

