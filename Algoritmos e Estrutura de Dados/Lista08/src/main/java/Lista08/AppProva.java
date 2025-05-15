package Lista08;

public class AppProva {
    public static void main(String[] args) {

        Arvore<String> arvore = new Arvore<>();

        //         A
        //      / | \
        //     B  C  D
        //    / \    |
        //   E   F   H
        //  /
        // G

        // Montando a árvore manualmente:
        NoArvore<String> raiz = new NoArvore<>("A");
        NoArvore<String> b = new NoArvore<>("B");
        NoArvore<String> c = new NoArvore<>("C");
        NoArvore<String> d = new NoArvore<>("D");
        NoArvore<String> e = new NoArvore<>("E");
        NoArvore<String> f = new NoArvore<>("F");
        NoArvore<String> g = new NoArvore<>("G");
        NoArvore<String> h = new NoArvore<>("H");



        // Montando filhos
        raiz.setPrimeiro(b);
        b.setProximo(c);
        c.setProximo(d);
        b.setPrimeiro(e);
        e.setProximo(f);
        e.inserirFilho(g);
        d.setPrimeiro(h);
        // ou
        // raiz.inserirFilho(d);
        // raiz.inserirFilho(c);
        // raiz.inserirFilho(b);
        // b.inserirFilho(f);
        // b.inserirFilho(e);

        arvore.setRaiz(raiz);

        System.out.println(arvore.toString());
        System.out.println(arvore.contarNosInternos());



    }
}
