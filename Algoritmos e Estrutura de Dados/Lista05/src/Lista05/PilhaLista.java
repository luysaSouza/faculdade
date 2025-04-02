package Lista05;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    /**
     * Adiciona um elemento no topo da pilha.
     *
     * @param valor Elemento a ser empilhado.
     */
    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     *
     * @return Elemento removido do topo da pilha.
     */
    @Override
    public T pop() {
        T valor;
        valor = peek();
        lista.retirar(valor); //o comando RETIRAR vai ser rapido pois ele sempre vai pegar o primeiro elemento que foi informado no peek(), vai ser o mesmo tempo com 1 elemento ou 1 milhao de elementos 

        return valor;
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     *
     * @return Elemento no topo da pilha.
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return lista.getPrimeiro().getInfo();
    }

    /**
     * Retorna true se a pilha estiver vazia
     *
     * @return true se a pilha estiver vazia, false se a pilha conter dados
     */
    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    /**
     * Remove todos os elementos da pilha, tornando-a vazia.
     */
    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    /**
     * Retorna uma representação em string da pilha, onde os elementos são
     * exibidos do topo para a base, separados por vírgulas.
     *
     * @return Uma string com os elementos da pilha
     */
    @Override
    public String toString() {
        return lista.toString();
    }
}
