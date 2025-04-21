package Lista08;

public class App {
    public static void main(String[] args) {
        NoArvore<String> no1 = new NoArvore<>("A");
        NoArvore<String> no2 = new NoArvore<>("B");
        NoArvore<String> no3 = new NoArvore<>("C");
        NoArvore<String> no4 = new NoArvore<>("D");
        NoArvore<String> no5 = new NoArvore<>("E");
        NoArvore<String> no6 = new NoArvore<>("F");
        NoArvore<String> no7 = new NoArvore<>("G");

        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        no2.inserirFilho(no5);
        no2.inserirFilho(no4);

        no5.inserirFilho(no7);

        no3.inserirFilho(no6);

        Arvore<String> arvore = new Arvore<>();

        arvore.setRaiz(no1);

        System.out.println(arvore.toString());
    }
}
