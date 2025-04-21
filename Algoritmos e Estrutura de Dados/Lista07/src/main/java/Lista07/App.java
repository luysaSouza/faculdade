package Lista07;

public class App {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        //        10
        //       /  \
        //      5    15
        //     / \     \
        //    3   7     20

        // Criando os nós manualmente
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(10);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(15);
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(20);

        // Montando a árvore
        n1.setEsquerda(n2);
        n1.setDireita(n3);
        n2.setEsquerda(n4);
        n2.setDireita(n5);
        n3.setDireita(n6);

        arvore.setRaiz(n1);

        System.out.println("Árvore (pré, ordem, pós):");
        System.out.println(arvore.toString());

        System.out.println("Está vazia? " + arvore.estaVazia());
        System.out.println("Contém o número 7? " + arvore.pertence(7));
        System.out.println("Contém o número 99? " + arvore.pertence(99));

        System.out.println("Número total de nós: " + arvore.contarNos());
        System.out.println("Altura da árvore: " + arvore.calcularAltura());

        System.out.println("Contagem de pais, filhos e folhas:");
        arvore.contarPaisFilhosFolhas();

        System.out.println("A árvore é cheia? " + arvore.ehCheia());
        System.out.println("Número de folhas: " + arvore.contarFolhas());
        System.out.println("Número de nós no nível 2: " + arvore.contarNosNivel(2));
        System.out.println("A árvore é estritamente binária? " + arvore.ehEstritamenteBinaria());
        System.out.println("Número de nós com um único filho: " + arvore.contarNosComUmFilho());

        System.out.println("Removendo o nó 7...");
        arvore.remover(7);
        System.out.println(arvore);

        System.out.println("Removendo a subárvore com raiz 5...");
        arvore.removerSubarvore(5);
        System.out.println(arvore);

        System.out.println("Removendo o nó 10 (raiz)...");
        arvore.remover(10);
        System.out.println(arvore);
    }
}
