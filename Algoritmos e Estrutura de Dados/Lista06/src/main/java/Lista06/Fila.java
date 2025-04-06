package Lista06;

public interface Fila<T> {

    void inserir(T valor);
    boolean estaVazia();
    T peek();
    T retirar();
    void liberar();
}
