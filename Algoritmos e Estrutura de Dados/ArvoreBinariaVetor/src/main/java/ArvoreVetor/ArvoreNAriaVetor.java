package ArvoreVetor;

import java.util.*;

public class ArvoreNAriaVetor {
    private List<String> valores;
    private List<List<Integer>> filhos;

    public ArvoreNAriaVetor() {
        valores = new ArrayList<>();
        filhos = new ArrayList<>();
    }

    // Insere um novo nó e retorna o índice dele
    public int inserir(String valor) {
        valores.add(valor);
        filhos.add(new ArrayList<>());
        return valores.size() - 1; // retorna índice do novo nó
    }

    // Liga pai a filho (usando índices)
    public void adicionarFilho(int indicePai, int indiceFilho) {
        filhos.get(indicePai).add(indiceFilho);
    }

    // Exibe a árvore em forma textual (pré-ordem)
    public void exibir(int indice) {
        System.out.print("<" + valores.get(indice));
        for (int filho : filhos.get(indice)) {
            exibir(filho);
        }
        System.out.print(">");
    }
}

