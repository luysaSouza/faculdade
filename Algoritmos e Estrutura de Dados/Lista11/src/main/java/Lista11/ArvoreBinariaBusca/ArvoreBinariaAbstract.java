package Lista11.ArvoreBinariaBusca;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    /**
     * Cria uma arvore vazia
     */
    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
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
        return buscar(info) != null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    /**
     * Retorna uma representação em forma de string da árvore binária
     * utilizando percurso em pré-ordem com marcações de início e fim de cada subárvore.
     *
     * @return uma string representando a árvore.
     */
    @Override
    public String toString() {
        return arvorePre(raiz);
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
}