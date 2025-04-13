package Lista07;

public class App {
    public static void main(String[] args) {

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);

        arvore.setRaiz(n1);

        n1.setEsquerda(n2);
        n1.setDireita(n3);
        n2.setDireita(n4);
        n3.setEsquerda(n5);
        n3.setDireita(n6);

        System.out.println(arvore.toString());
    }
}
