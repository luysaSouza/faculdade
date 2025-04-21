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

    /**
     * Inverte a ordem dos elementos da fila atual.
     * O primeiro elemento passa a ser o último e assim por diante.
     * Essa operação é feita in-place, sem utilizar estruturas auxiliares.
     */
    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            int indice1 = (inicio + i) % limite;
            int indice2 = (inicio + tamanho - 1 - i) % limite;

            Object temp = info[indice1];
            info[indice1] = info[indice2];
            info[indice2] = temp;
        }
    }

    /**
     * Conta quantas vezes um determinado valor aparece na fila.
     *
     * @param valor Valor a ser buscado na fila.
     * @return Quantidade de ocorrências do valor na fila.
     */
    public int contarOcorrencias(T valor) {
        int contador = 0;

        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite;
            if (info[indice].equals(valor)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Insere um elemento no início da fila, deslocando os elementos existentes.
     *
     * @param valor O valor a ser inserido no início da fila.
     * @throws FilaCheiaException Se a fila estiver cheia.
     */
    public void inserirComPrioridade(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        inicio = (inicio - 1 + limite) % limite;
        info[inicio] = valor;
        tamanho++;
    }

    /**
     * Verifica se a fila atual é igual a outra fila passada por parâmetro.
     * A igualdade considera o mesmo tamanho e os mesmos elementos na mesma ordem.
     *
     * @param outra A outra fila a ser comparada.
     * @return true se forem iguais; false caso contrário.
     */
    public boolean ehIgual(FilaVetor<T> outra) {
        if (this.tamanho != outra.tamanho) {
            return false;
        }

        for (int i = 0; i < this.tamanho; i++) {
            int indice1 = (this.inicio + i) % this.limite;
            int indice2 = (outra.inicio + i) % outra.limite;

            if (!this.info[indice1].equals(outra.info[indice2])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Retorna a posição do valor na fila, considerando o início como posição 0.
     *
     * @param valor Valor a ser buscado.
     * @return Posição relativa na fila, ou -1 se não estiver presente.
     */
    public int posicaoDoElemento(T valor) {
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite;
            if (info[indice].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove a primeira ocorrência do valor especificado na fila.
     * Se o valor não estiver presente, a fila permanece inalterada.
     *
     * @param valor Valor a ser removido.
     * @return true se o valor foi encontrado e removido; false caso contrário.
     */
    public boolean removerElemento(T valor) {
        boolean encontrado = false;
        FilaVetor<T> auxiliar = new FilaVetor<>(limite);

        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % limite;
            T atual = (T) info[indice];

            if (!encontrado && atual.equals(valor)) {
                encontrado = true; // não insere na auxiliar
            } else {
                auxiliar.inserir(atual);
            }
        }

        if (encontrado) {
            this.info = auxiliar.info;
            this.inicio = auxiliar.inicio;
            this.tamanho = auxiliar.tamanho;
            // O limite não muda pois foi criado com o mesmo tamanho
        }

        return encontrado;
    }
}
