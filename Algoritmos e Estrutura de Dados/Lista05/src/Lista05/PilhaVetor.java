package Lista05;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;
    private int limite;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public Object[] getInfo() {
        return info;
    }

    /**
     * Cria uma pilha com o tamanho especifico
     *
     * @param limite Capacidade máxima de empilhamento
     */
    public PilhaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    /**
     * Empilha um dado
     *
     * @param valor Dado a ser empilhado
     */
    @Override
    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
            // redimensionar();
        }

        this.info[tamanho] = valor;
        tamanho++;
    }

    /**
     * Retira um dado da pilha e devolver o dado removido
     *
     * @return Dado desempilhado
     */
    @Override
    public T pop() {
        T valor = peek();
        info[tamanho - 1] = null;
        tamanho--;

        return valor;
    }

    /**
     * Retorna o conteúdo do topo da pilha
     *
     * @return Topo da pilha
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return (T) info[tamanho - 1];
    }

    /**
     * Retorna true se a pilha estiver vazia
     *
     * @return true se a pilha estiver vazia, false se a pilha conter dados
     */
    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void liberar() {
        // 1a versao, é mais rapido que todas as outras solucoes em Java
        info = new Object[limite];
        tamanho = 0;

        /* 2a versao
        for (int i = 0; i < tamanho; i++) {
            info[i] = null;
        }
        this.tamanho = 0;
         */
 /* 3a versao 
        while (!estaVazia()){
            pop();
        }
         */
 /* 4a versao 
        try {
            while (true) {
                pop();
            }
        } catch (PilhaVaziaException e) {
        }
         */
    }

    /**
     * Retorna uma representação em string da pilha, onde os elementos são
     * exibidos do topo para a base, separados por vírgulas.
     *
     * @return Uma string com os elementos da pilha
     */
    @Override
    public String toString() {
        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado += ",";
            }
        }

        return resultado;
    }

    /**
     * Concatena outra pilha à pilha atual, empilhando seus elementos na ordem original
     *
     * @param p Pilha a ser concatenada
     */
    public void concatenar(PilhaVetor<T> p) {
        if (this.tamanho + p.tamanho > this.limite) {
            throw new RuntimeException("Nao ha espaco para empilhar todos os dados");
        }

        for (int i = 0; i < p.tamanho; i++) {
            this.push((T) p.info[i]);
        }
    }

    private void redimensionar() {
        int novoLimite = limite * 2;
        Object[] novoInfo = new Object[novoLimite];

        for (int i = 0; i < tamanho; i++) {
            novoInfo[i] = info[i];
        }

        info = novoInfo;
        limite = novoLimite;
    }

    /**
     * Retorna o menor valor presente na pilha.
     *
     * @return O valor mínimo encontrado na pilha.
     * @throws PilhaVaziaException Se a pilha estiver vazia.
     */
    public T minimo() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T minimo = (T) info[0];
        for (int i = 1; i < tamanho; i++) {
            if (((Comparable<T>) info[i]).compareTo(minimo) < 0) {
                minimo = (T) info[i];
            }
        }

        return minimo;
    }

    /**
     * Retorna uma nova pilha contendo os mesmos elementos da pilha atual, mas com a ordem invertida.
     * A pilha original não é modificada.
     *
     * @return Uma nova pilha com os elementos invertidos.
     */
    public PilhaVetor<T> invertida() {
        PilhaVetor<T> pilhaInvertida = new PilhaVetor<>(this.limite);

        for (int i = tamanho - 1; i >= 0; i--) {
            pilhaInvertida.push((T) info[i]);
        }

        return pilhaInvertida;
    }

    /**
     * Remove a primeira ocorrência de um valor específico da pilha.
     * Caso o valor não seja encontrado, o metodo retorna false
     * Caso contrário, a pilha será reordenada para "ocupar" o espaço deixado pelo valor removido.
     *
     * @param valor O valor a ser removido da pilha.
     * @return true se o valor foi removido com sucesso, false caso contrário.
     */
    public boolean remover(T valor) {
        if (estaVazia()) {
            return false;
        }

        int indice = -1;
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            return false; // Valor não encontrado
        }

        // Desloca os elementos para preencher o espaço
        for (int i = indice; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }

        info[tamanho - 1] = null;
        tamanho--;
        return true;
    }

    /**
     * Conta quantas vezes um valor específico aparece na pilha.
     *
     * @param valor O valor a ser contado na pilha.
     * @return O número de ocorrências do valor na pilha.
     */
    public int contarOcorrencias(T valor) {
        int contador = 0;

        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Dobra o valor do topo da pilha, ou seja, empilha o valor atual do topo duas vezes.
     *
     * @throws PilhaVaziaException Se a pilha estiver vazia.
     */
    public void duplicarTopo() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T topo = peek();
        push(topo); // Empilha o topo novamente
    }

    /**
     * Busca a posição de um elemento a partir do topo da pilha.
     *
     * @param valor O valor a ser buscado na pilha.
     * @return A posição do valor a partir do topo, ou -1 se não encontrado.
     */
    public int buscar(T valor) {
        for (int i = tamanho - 1, pos = 0; i >= 0; i--, pos++) {
            if (info[i].equals(valor)) {
                return pos;
            }
        }
        return -1;
    }
}
