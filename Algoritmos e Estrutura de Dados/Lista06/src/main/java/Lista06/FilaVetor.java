package Lista06;

public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    /**
     * Cria uma fila com determinada capacidade de armazenamento
     *
     * @param limite Quantidade maxim de dados que poderao ser enfileirados
     */
    public FilaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    /**
     * Insere um novo dado na fila
     *
     * @param valor Dador a ser enfileirado
     */
    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
            //redimensionar();
        }

        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    /**
     * Avalia se a fila esta vazia
     */
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o elemento que esta no inicio da fila
     *
     * @return Dado que esta no inicio da fila
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    /**
     * Retira um elemento da fila
     *
     * @return Dado retirado
     */
    @Override
    public T retirar() {
        T backup = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return backup;
    }

    /**
     * Desinfilera todos os itens da fila
     */
    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }

    /**
     * Cria uma nova fila, tomando como base uma fila pre-existente
     *
     * @param f2 Fila a ser concatenada á atual
     * @return Fila resultante da concatenacao
     */
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        // PROFESSOR
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.getLimite());

        int posicao = this.inicio;
        for (int i = 0; i < this.tamanho; i++){
            f3.inserir((T) this.info[posicao]);
            posicao = (posicao + 1) % this.limite;
        }

        posicao = f2.inicio;
        for (int i = 0; i < f2.tamanho; i++){
            f3.inserir((T) f2.info[posicao]);
            posicao = (posicao + 1) % f2.limite;
        }

        return f3;
    }

    /**
     * Retorna representacao textual da fila, partindo do inico ate o final. Os dados sao separador por virgula
     *
     * @return Conteudo da fila
     */
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite;
            if (i > 0) {
                resultado += ",";
            }
            resultado += info[indice];
        }

        return resultado;

        // PROFESSOR
        /*
        String resultado = "";
        int posicao = inicio;
        for (int i = 0; i < tamanho; i++){
            if (i > 0){
                resultado += ",";
            }
            resultado += info[posicao];
            posicao = (posicao + 1) % limite;
        }
        */
    }

    /**
     * Metodo getter da variavel limite da fila
     * @return Limite da fila
     */
    public int getLimite() {
        return limite;
    }

    private void redimensionar() {
        int novoLimite = limite * 2;
        Object[] novoInfo = new Object[novoLimite];

        for (int i = 0; i < tamanho; i++) {
            int indiceAntigo = (inicio + i) % limite;
            novoInfo[i] = info[indiceAntigo];
        }

        info = novoInfo;
        limite = novoLimite;
        inicio = 0;
    }
}
