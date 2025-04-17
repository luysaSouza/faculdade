package Lista08;

public class App {
    public static void main(String[] args) {

        NoArvore<Integer> no1 = new NoArvore<>(1);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(4);
        NoArvore<Integer> no4 = new NoArvore<>(3);

        no1.inserirFilho(no2);
        no2.inserirFilho(no3);
        no2.inserirFilho(no4);

        Arvore<Integer> arvore = new Arvore<>();

        arvore.setRaiz(no1);

        System.out.println(arvore.pertence(0));
        System.out.println(arvore.contarNos());
    }
}
