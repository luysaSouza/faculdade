package Lista05;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T valor;
        valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
