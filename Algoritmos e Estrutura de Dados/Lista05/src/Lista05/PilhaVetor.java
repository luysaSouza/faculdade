package Lista05;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T valor) {
        if (limite == tamanho) {
            throw new PilhaCheiaException();
        }

        info[tamanho] = valor;
        tamanho = tamanho + 1;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        
        T valor;
        valor = peek();
        info[tamanho - 1] = null;
        tamanho = tamanho - 1;
        
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return (T) info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = tamanho-1; i >= 0; i--) {
            if (i != tamanho-1) {
                resultado += ",";
            }
            resultado += info[i];
        }

        return resultado;
    }
    
    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i <= p.tamanho-1; i++) {
            push((T) p.info[i]);
        }
    }
}
