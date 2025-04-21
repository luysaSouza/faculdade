package Lista07;

public class App {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        // Criando manualmente a árvore:
        //         10
        //        /  \
        //       5    15
        //      / \     \
        //     3   7     20

        NoArvoreBinaria<Integer> no10 = new NoArvoreBinaria<>(10);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no15 = new NoArvoreBinaria<>(15);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no20 = new NoArvoreBinaria<>(20);

        // Conectando os nós
        no10.setEsquerda(no5);
        no10.setDireita(no15);
        no5.setEsquerda(no3);
        no5.setDireita(no7);
        no15.setDireita(no20);

        // Definindo a raiz da árvore
        arvore.setRaiz(no10);

        System.out.println("Antes da remoção da subárvore:");
        System.out.println(arvore.toString());

        boolean removeuSubarvore = arvore.removerSubarvore(5);
        System.out.println("Removeu subárvore do nó 5? " + removeuSubarvore);

        System.out.println("Após a remoção da subárvore:");
        System.out.println(arvore.toString());
    }
}
