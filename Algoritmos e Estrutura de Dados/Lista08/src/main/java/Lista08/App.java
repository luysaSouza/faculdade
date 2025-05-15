//package Lista08;
//
//public class App {
//    public static void main(String[] args) {
//        Arvore<String> arvore = new Arvore<>();
//
//        //         A
//        //      / | \
//        //     B  C  D
//        //    / \
//        //   E   F
//
//        // Montando a árvore manualmente:
//        NoArvore<String> raiz = new NoArvore<>("A");
//        NoArvore<String> b = new NoArvore<>("B");
//        NoArvore<String> c = new NoArvore<>("C");
//        NoArvore<String> d = new NoArvore<>("D");
//        NoArvore<String> e = new NoArvore<>("E");
//        NoArvore<String> f = new NoArvore<>("F");
//
//        // Montando filhos
//        raiz.setPrimeiro(b);
//        b.setProximo(c);
//        c.setProximo(d);
//        b.setPrimeiro(e);
//        e.setProximo(f);
//        // ou
//        // raiz.inserirFilho(d);
//        // raiz.inserirFilho(c);
//        // raiz.inserirFilho(b);
//        // b.inserirFilho(f);
//        // b.inserirFilho(e);
//
//        arvore.setRaiz(raiz);
//
//        // Exibição da árvore
//        System.out.println("Árvore: " + arvore);
//
//        // Testa pertence
//        System.out.println("Pertence B? " + arvore.pertence("B"));
//        System.out.println("Pertence Z? " + arvore.pertence("Z"));
//
//        // Conta os nós
//        System.out.println("Quantidade de nós: " + arvore.contarNos());
//
//        // Conta folhas
//        System.out.println("Quantidade de folhas: " + arvore.contarFolhas());
//
//        // Altura
//        System.out.println("Altura da árvore: " + arvore.altura());
//
//        // Buscar nó de maior profundidade
//        NoArvore<String> maisProfundo = arvore.buscarMaiorProfundidade();
//        if (maisProfundo != null)
//            System.out.println("Nó mais profundo: " + maisProfundo.getInfo());
//
//        // Encontrar pai de um nó
//        NoArvore<String> paiE = arvore.encontrarPai("E");
//        if (paiE != null)
//            System.out.println("Pai de E: " + paiE.getInfo());
//
//        // Buscar valor máximo (assumindo que as letras são comparáveis)
//        NoArvore<String> max = arvore.buscarMaximo();
//        if (max != null)
//            System.out.println("Maior valor da árvore: " + max.getInfo());
//
//        // Contar nós no nível
//        int nivel = 2;
//        System.out.println("Nós no nível " + nivel + ": " + arvore.contarNosNoNivel(2));
//
//        // Inverter árvore
//        arvore.inverter();
//        System.out.println("Árvore invertida: " + arvore);
//
//        // Remover um nó
//        boolean removido = arvore.remover("B");
//        System.out.println("Removeu B? " + removido);
//        System.out.println("Árvore após remoção: " + arvore);
//
//        Arvore<String> arvoreString = new Arvore<>();
//        arvore.construirDeTexto("<A<D><C><B<F><E>>>");
//
//        System.out.println("Árvore reconstruída:");
//        System.out.println(arvoreString.toString());  // deve imprimir igual à entrada
//    }
//}
