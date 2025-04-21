package Lista08;

public class App {
    public static void main(String[] args) {
        // Criando uma árvore de inteiros
        Arvore<Integer> arvore = new Arvore<>();

        // Criando alguns nós (exemplo de NoArvore)
        NoArvore<Integer> raiz = new NoArvore<>(1); // Raiz
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no5 = new NoArvore<>(5);

        // Estabelecendo os filhos da raiz (arvore de exemplo)
        raiz.setPrimeiro(no2);
        no2.setProximo(no3);
        no3.setProximo(no4);
        no4.setProximo(no5);

        no4.inserirFilho(no5);
        no4.inserirFilho(no3);
        no4.inserirFilho(no2);

        arvore.setRaiz(raiz);
        // Testando o método "buscarMaiorProfundidade"
        NoArvore<Integer> noMaiorProfundidade = arvore.buscarMaiorProfundidade();
        System.out.println("Nó de maior profundidade: " + (noMaiorProfundidade != null ? noMaiorProfundidade.getInfo() : "Árvore vazia"));

        System.out.println(arvore.toString());
    }
}
