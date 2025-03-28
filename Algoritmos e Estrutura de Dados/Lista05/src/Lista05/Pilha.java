package Lista05;

public interface Pilha<T> {
    
    public abstract void push(T valor);
    public abstract T pop();
    public abstract T peek();
    public abstract boolean estaVazia();
    public abstract void liberar();
}
