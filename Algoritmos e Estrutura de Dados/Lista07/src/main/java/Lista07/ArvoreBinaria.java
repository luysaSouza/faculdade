package Lista07;

public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    /**
     * Cria uma arvore vazia
     */
    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Avalia se a arvore esta vazia
     *
     * @return True se a arvore estiver vazia, senao false
     */
    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    /**
     * Verifica se um determinado elemento pertence à árvore binária.
     * A busca é feita em pré-ordem.
     *
     * @param no   o nó atual da árvore durante a busca.
     * @param info o valor a ser procurado.
     * @return {@code true} se o elemento estiver na árvore, {@code false} caso contrário.
     */
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        // PRÉ-ORDEM
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info) ||
                    pertence(no.getEsquerda(), info) ||
                    pertence(no.getDireita(), info);
        }

        // OU

        // PRÉ-ORDEM
//        if (no == null) {
//            return false;
//        } else { // nao vazia
//            if (no.getInfo().equals(info))
//                return true;
//             else {
//                if (pertence(no.getEsquerda(), info))
//                    return true;
//                else
//                    return (pertence(no.getDireita(), info));
//                }
//            }
//        }

        // ORDEM SIMETRICA
//        if (no == null){
//            return false;
//        } else {
//            return (pertence(no.getEsquerda(), info) ||
//                    no.getInfo().equals(info)) ||
//                    pertence(no.getDireita(), info);
//        }
//
//        // PÓS-ORDEM
//        if (no == null){
//            return false;
//        } else {
//            return (pertence(no.getEsquerda(), info) ||
//                    pertence(no.getDireita(), info) ||
//                    no.getInfo().equals(info));
//        }
    }

    /**
     * Retorna uma representação em forma de string da árvore binária
     * utilizando percurso em pré-ordem com marcações de início e fim de cada subárvore.
     *
     * @return uma string representando a árvore.
     */
    @Override
    public String toString() {
        return arvorePre(raiz) + "\n" + arvoreOrdem(raiz) + "\n" + arvorePos(raiz);
    }

    /**
     * Gera a representação em string da árvore a partir do nó fornecido,
     * utilizando percurso em pré-ordem.
     *
     * @param no o nó a partir do qual a árvore será representada.
     * @return a representação em string da subárvore iniciada em {@code no}.
     */
    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        // PROFESSOR
        return "<" +
                no.getInfo() +
                arvorePre(no.getEsquerda()) +
                arvorePre(no.getDireita()) +
                ">";
    }

    private String arvoreOrdem(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        return "<" +
                arvoreOrdem(no.getEsquerda()) +
                no.getInfo() +
                arvoreOrdem(no.getDireita()) +
                ">";
    }

    private String arvorePos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }

        return "<" +
                arvorePos(no.getEsquerda()) +
                arvorePos(no.getDireita()) +
                no.getInfo() +
                ">";
    }

    /**
     * Conta o número total de nós presentes na árvore binária.
     *
     * @return o número total de nós na árvore.
     */
    public int contarNos() {
        return contarNos(raiz);
    }

    /**
     * Conta o número de nós da subárvore iniciada em {@code no}.
     *
     * @param no o nó a partir do qual a contagem será feita.
     * @return o número de nós na subárvore iniciada em {@code no}.
     */
    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        return 1 + contarNos(no.getEsquerda()) +
                contarNos(no.getDireita());
    }

    /**
     * Calcula a altura da árvore binária.
     * A altura é o número máximo de arestas entre a raiz e a folha mais distante.
     *
     * @return a altura da árvore.
     */
    public int calcularAltura() {
        return calcularAltura(raiz);
    }

    /**
     * Calcula a altura da subárvore iniciada no nó fornecido.
     *
     * @param no o nó a partir do qual a altura será calculada.
     * @return a altura da subárvore iniciada em {@code no}.
     */
    private int calcularAltura(NoArvoreBinaria<T> no) {
        if (no == null) {
            return -1;
        }

        return Math.max(calcularAltura(no.getEsquerda()), calcularAltura(no.getDireita())) + 1;
    }

    public void contarPaisFilhosFolhas() {
        int[] contagem = new int[3];
        contarPaisFilhosFolhas(raiz, contagem);

        System.out.println("Pais: " + contagem[0]);
        System.out.println("Filhos: " + contagem[1]);
        System.out.println("Folhas: " + contagem[2]);
    }

    /**
     * Metodo recursivo para contar pais, filhos e folhas.
     */
    private void contarPaisFilhosFolhas(NoArvoreBinaria<T> no, int[] contagem) {
        if (no == null) {
            return;
        }

        if (no.getEsquerda() != null || no.getDireita() != null) {
            contagem[0]++;
        }

        if (no.getEsquerda() != null) {
            contagem[1]++;
        }
        if (no.getDireita() != null) {
            contagem[1]++;
        }

        if (no.getEsquerda() == null && no.getDireita() == null) {
            contagem[2]++;
        }

        contarPaisFilhosFolhas(no.getEsquerda(), contagem);
        contarPaisFilhosFolhas(no.getDireita(), contagem);
    }

    /**
     * Verifica se a árvore binária é cheia.
     * Uma árvore cheia é aquela em que todos os nós possuem 0 ou 2 filhos.
     *
     * @return {@code true} se a árvore for cheia, {@code false} caso contrário.
     */
    public boolean ehCheia() {
        return ehCheia(raiz);
    }

    private boolean ehCheia(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        if ((no.getEsquerda() == null && no.getDireita() != null) ||
                (no.getEsquerda() != null && no.getDireita() == null)) {
            return false;
        }

        return ehCheia(no.getEsquerda()) && ehCheia(no.getDireita());
    }

    /**
     * Conta o número de folhas da árvore binária.
     * Uma folha é um nó que não possui filhos.
     *
     * @return o número de folhas na árvore.
     */
    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        if (no.getEsquerda() == null && no.getDireita() == null) {
            return 1;
        }

        return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }

    /**
     * Conta quantos nós existem em um determinado nível da árvore.
     *
     * @param nivel o nível desejado (começa do 0 para a raiz).
     * @return o número de nós presentes no nível especificado.
     */
    public int contarNosNivel(int nivel) {
        return contarNosNivel(raiz, nivel, 0);
    }

    private int contarNosNivel(NoArvoreBinaria<T> no, int nivelAlvo, int nivelAtual) {
        if (no == null) {
            return 0;
        }

        if (nivelAtual == nivelAlvo) {
            return 1;
        }

        return contarNosNivel(no.getEsquerda(), nivelAlvo, nivelAtual + 1) +
                contarNosNivel(no.getDireita(), nivelAlvo, nivelAtual + 1);
    }

    /**
     * Remove um nó com a informação fornecida da árvore binária.
     * A remoção busca o nó e faz substituições apropriadas.
     *
     * @param valor o valor a ser removido da árvore.
     * @return {@code true} se o nó foi removido, {@code false} se não foi encontrado.
     */
    public boolean remover(T valor) {
        if (raiz == null) return false;

        if (raiz.getInfo().equals(valor)) {
            raiz = removerNo(raiz);
            return true;
        }

        return remover(raiz, valor);
    }

    private boolean remover(NoArvoreBinaria<T> no, T valor) {
        if (no == null) {
            return false;
        }

        if (no.getEsquerda() != null && no.getEsquerda().getInfo().equals(valor)) {
            no.setEsquerda(removerNo(no.getEsquerda()));
            return true;
        } else if (no.getDireita() != null && no.getDireita().getInfo().equals(valor)) {
            no.setDireita(removerNo(no.getDireita()));
            return true;
        }

        return remover(no.getEsquerda(), valor) || remover(no.getDireita(), valor);
    }

    /**
     * Remove efetivamente um nó, substituindo-o de forma apropriada.
     * Se tiver dois filhos, promove o filho esquerdo e "adota" o direito.
     */
    private NoArvoreBinaria<T> removerNo(NoArvoreBinaria<T> no) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return null;
        }

        if (no.getEsquerda() == null) {
            return no.getDireita();
        }

        if (no.getDireita() == null) {
            return no.getEsquerda();
        }

        // Tem dois filhos: vamos promover o filho esquerdo e colocar o direito na direita mais à direita da esquerda
        NoArvoreBinaria<T> substituto = no.getEsquerda();
        NoArvoreBinaria<T> paiSubstituto = no;

        while (substituto.getDireita() != null) {
            paiSubstituto = substituto;
            substituto = substituto.getDireita();
        }

        // "Remover" o substituto do lugar antigo
        if (paiSubstituto != no) {
            paiSubstituto.setDireita(substituto.getEsquerda());
            substituto.setEsquerda(no.getEsquerda());
        }

        substituto.setDireita(no.getDireita());
        return substituto;
    }

    /**
     * Remove o nó que contém o valor fornecido e toda a sua subárvore.
     *
     * @param valor o valor do nó a ser removido.
     * @return {@code true} se o nó foi encontrado e removido, {@code false} caso contrário.
     */
    public boolean removerSubarvore(T valor) {
        if (raiz == null) return false;

        if (raiz.getInfo().equals(valor)) {
            raiz = null; // Remove toda a árvore
            return true;
        }

        return removerSubarvore(raiz, valor);
    }

    private boolean removerSubarvore(NoArvoreBinaria<T> no, T valor) {
        if (no == null) return false;

        if (no.getEsquerda() != null && no.getEsquerda().getInfo().equals(valor)) {
            no.setEsquerda(null); // Remove toda a subárvore da esquerda
            return true;
        }

        if (no.getDireita() != null && no.getDireita().getInfo().equals(valor)) {
            no.setDireita(null); // Remove toda a subárvore da direita
            return true;
        }

        // Continua buscando nos filhos
        return removerSubarvore(no.getEsquerda(), valor) || removerSubarvore(no.getDireita(), valor);
    }

    /**
     * Verifica se a árvore é estritamente binária,
     * ou seja, todos os nós possuem 0 ou 2 filhos.
     *
     * @return {@code true} se a árvore for estritamente binária, {@code false} caso contrário.
     */
    public boolean ehEstritamenteBinaria() {
        return ehEstritamenteBinaria(raiz);
    }

    private boolean ehEstritamenteBinaria(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        NoArvoreBinaria<T> esq = no.getEsquerda();
        NoArvoreBinaria<T> dir = no.getDireita();

        if ((esq == null && dir != null) || (esq != null && dir == null)) {
            return false;
        }

        return ehEstritamenteBinaria(esq) && ehEstritamenteBinaria(dir);
    }

    /**
     * Conta o número de nós que possuem exatamente um filho.
     *
     * @return o número de nós com apenas um filho.
     */
    public int contarNosComUmFilho() {
        return contarNosComUmFilho(raiz);
    }

    private int contarNosComUmFilho(NoArvoreBinaria<T> no) {
        if (no == null) return 0;

        int count = 0;

        if ((no.getEsquerda() == null && no.getDireita() != null) ||
                (no.getEsquerda() != null && no.getDireita() == null)) {
            count = 1;
        }

        return count + contarNosComUmFilho(no.getEsquerda()) + contarNosComUmFilho(no.getDireita());
    }
}
