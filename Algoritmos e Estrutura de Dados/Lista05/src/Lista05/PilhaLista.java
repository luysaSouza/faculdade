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

    /**
     * Retorna uma nova pilha contendo os mesmos elementos da pilha atual, porém em ordem invertida.
     * A pilha original não é modificada.
     *
     * @return Uma nova pilha com os elementos em ordem inversa.
     */
    public PilhaLista<T> inverter() {
        PilhaLista<T> pilhaInvertida = new PilhaLista<>();
        NoLista<T> atual = lista.getPrimeiro();

        while (atual != null) {
            pilhaInvertida.push(atual.getInfo());
            atual = atual.getProximo();
        }

        return pilhaInvertida;
    }

    /**
     * Verifica se um determinado valor está presente na pilha.
     *
     * @param valor O valor a ser procurado.
     */
    public boolean buscar(T valor) {
        NoLista<T> atual = lista.getPrimeiro();
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    /**
     * Concatena os elementos de uma PilhaVetor à pilha atual (PilhaLista),
     * mantendo a ordem original da PilhaVetor.
     * Os elementos da PilhaVetor serão empilhados no topo desta PilhaLista.
     *
     * @param outraPilha A pilha do tipo PilhaVetor cujos elementos serão concatenados.
     * @throws RuntimeException se a outra pilha for nula.
     */
    public void concatenarComPilhaVetor(PilhaVetor<T> outraPilha) {
        if (outraPilha == null) {
            throw new RuntimeException("Pilha passada como parâmetro está nula");
        }

        // Cria uma pilha auxiliar para inverter a PilhaVetor e manter a ordem original
        PilhaVetor<T> auxiliar = new PilhaVetor<>(outraPilha.getTamanho());

        for (int i = outraPilha.getTamanho() - 1; i >= 0; i--) {
            auxiliar.push((T) outraPilha.getInfo()[i]);
        }

        while (!auxiliar.estaVazia()) {
            this.push(auxiliar.pop());
        }
    }
}
