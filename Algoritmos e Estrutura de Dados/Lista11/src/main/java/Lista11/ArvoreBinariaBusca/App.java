package Lista11.ArvoreBinariaBusca;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        // Inserção de elementos
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arvore.inserir(v);
        }

        System.out.println("Árvore criada com valores: 50, 30, 70, 20, 40, 60, 80");

        // Testes dos métodos
        System.out.println("Buscar 60: " + (arvore.buscar(60) != null));
        System.out.println("Buscar 90: " + (arvore.buscar(90) != null));

        System.out.println("Está vazia? " + arvore.estaVazia());

        System.out.println("Contar nós: " + arvore.contarNos());
        System.out.println("Contar folhas: " + arvore.contarFolhas());
        System.out.println("Contar nós internos: " + arvore.contarNosInternos());

        System.out.println("Altura da árvore: " + arvore.altura());
        System.out.println("Nível do valor 60: " + arvore.nivel(60));

        System.out.println("É folha (20)? " + arvore.ehFolha(20));
        System.out.println("É folha (30)? " + arvore.ehFolha(30));

        System.out.println("Buscar pai de 20: " +
                (arvore.buscarPai(20) != null ? arvore.buscarPai(20).getInfo() : "null"));

        System.out.println("Contar nós no nível 2: " + arvore.contarNosNoNivel(2));

        System.out.println("Buscar sucessor de 50: " + arvore.buscarSucessor(50));
        System.out.println("Buscar predecessor de 50: " + arvore.buscarPredecessor(50));

        System.out.println("Soma dos valores: " + arvore.somarValores());

        // Testando remoção
        System.out.println("\nRemover 70 (nó com dois filhos)");
        arvore.retirar(70);
        System.out.println("Buscar 70: " + (arvore.buscar(70) != null));

        System.out.println("Contar nós após remoção: " + arvore.contarNos());

        System.out.println(arvore.toString());

        System.out.println("A árvore é uma BST válida? " + arvore.ehABB());

        System.out.println("A árvore está balanceada? " + arvore.ehBalanceada());

        ArvoreBinariaBusca<Integer> arvore2 = new ArvoreBinariaBusca<>();

        arvore2.inserir(30);
        arvore2.inserir(15);
        arvore2.inserir(1);

        System.out.println("A árvore é degenerada? " + arvore2.ehDegenerada());

        ArvoreBinariaBusca<Integer> arvore3 = new ArvoreBinariaBusca<>();
        arvore3.inserir(50);
        arvore3.inserir(30);
        arvore3.inserir(70);
        arvore3.inserir(20);
        arvore3.inserir(40);
        arvore3.inserir(60);
        arvore3.inserir(80);

        List<Integer> vetorOrdenado = arvore3.paraVetorOrdenado();
        System.out.println("Vetor ordenado: " + vetorOrdenado);

        ArvoreBinariaBusca<Integer> arvore4 = new ArvoreBinariaBusca<>();

        Integer[] vetorOrdenado2 = {10, 20, 30, 40, 50, 60, 70};
        arvore4.construirArvoreDeVetor(vetorOrdenado2);

        System.out.println("Árvore construída a partir do vetor ordenado:");
        System.out.println(arvore4.toString());
    }
}
