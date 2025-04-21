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
}
