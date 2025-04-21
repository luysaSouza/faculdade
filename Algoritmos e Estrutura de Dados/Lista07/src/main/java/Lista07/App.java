package Lista07;

public class App {
    public static void main(String[] args) {

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);

        arvore.setRaiz(n1);

        n1.setDireita(n2);
        n2.setDireita(n3);
        n3.setDireita(n4);

        System.out.println(arvore.toString());
    }
}
