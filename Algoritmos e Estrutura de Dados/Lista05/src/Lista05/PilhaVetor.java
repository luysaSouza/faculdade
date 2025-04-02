package Lista05;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;
    private int limite;
    private int tamanho;

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
}
