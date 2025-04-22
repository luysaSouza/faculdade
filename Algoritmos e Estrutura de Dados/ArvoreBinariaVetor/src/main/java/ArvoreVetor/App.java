package ArvoreVetor;

public class App {
    public static void main(String[] args) {
        System.out.println("------------- ARVORE BINARIA -------------");
        ArvoreBinariaVetor arvoreB = new ArvoreBinariaVetor(15);

        // Inserindo elementos
        arvoreB.inserir(10);
        arvoreB.inserir(20);
        arvoreB.inserir(30);
        arvoreB.inserir(40);
        arvoreB.inserir(50);
        arvoreB.inserir(60);
        arvoreB.inserir(70);

        // Exibir os elementos em nível (em vetor)
        arvoreB.exibir();

        // Exibir a estrutura da árvore
        arvoreB.exibirEstrutura();

        System.out.println("------------- ARVORE N-ARIA -------------");
        ArvoreNAriaVetor arvoreN = new ArvoreNAriaVetor();

        // Inserindo nós
        int a = arvoreN.inserir("A");
        int b = arvoreN.inserir("B");
        int c = arvoreN.inserir("C");
        int d = arvoreN.inserir("D");
        int e = arvoreN.inserir("E");

        // Montando a árvore
        arvoreN.adicionarFilho(a, b); // A -> B
        arvoreN.adicionarFilho(a, c); // A -> C
        arvoreN.adicionarFilho(a, d); // A -> D
        arvoreN.adicionarFilho(c, e); // C -> E

        // Exibir a árvore
        arvoreN.exibir(a);
    }
}

