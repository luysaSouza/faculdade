package Lista06;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    /**
     * Insere um elemento na fila
     */
    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    /**
     * Avalia se a lista esta vazia
     */
    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    /**
     * Retorna o elemento que esta no inicio da fila
     * @return Dado que esta no inicio da fila
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return (T) lista.getPrimeiro().getInfo();
    }

    /**
     * Retira um elemento da fila
     */
    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    /**
     * Retira todos os elementos da fila
     */
    @Override
    public void liberar() {
        lista = new ListaEncadeada<T>();
    }

    /**
     * Retorna uma representacao textual da fila, partindo do inicio ate o final. Os dados sao separados por virgula
     *
     * @return Conteudo da fila
     */
    @Override
    public String toString() {
        return lista.toString();
    }
}
