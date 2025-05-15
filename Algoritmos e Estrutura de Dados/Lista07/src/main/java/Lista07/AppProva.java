package Lista07;

public class AppProva {
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

        n1.setEsquerda(n2);
        n1.setDireita(n3);
        n2.setEsquerda(n4);
        n2.setDireita(n5);
        n3.setDireita(n6);
        arvore.setRaiz(n1);

        System.out.println(arvore.contarFolhas());
        System.out.println(arvore.toString());
    }
}
