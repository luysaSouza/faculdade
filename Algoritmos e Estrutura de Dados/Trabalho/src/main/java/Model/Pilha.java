package Lista05;

public interface Pilha<T> {

    //nao é obrigatorio colocar PUBLIC e ABSTRACT pois em toda interface é tudo publico e abstrato
    void push(T valor);

    T pop();

    T peek();

    boolean estaVazia();

    void liberar();
}
