package Lista07;

public class App {
    public static void main(String[] args) {

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n8 = new NoArvoreBinaria<>(8);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n10 = new NoArvoreBinaria<>(10);
        NoArvoreBinaria<Integer> n14 = new NoArvoreBinaria<>(14);

        arvore.setRaiz(n8);

        n8.setEsquerda(n3);
        n8.setDireita(n10);
        n3.setEsquerda(n1);
        n3.setDireita(n6);
        n10.setDireita(n14);

        System.out.println(arvore.toString());
    }
}
