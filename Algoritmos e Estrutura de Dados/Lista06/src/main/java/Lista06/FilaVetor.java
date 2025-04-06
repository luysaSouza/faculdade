package Lista06;

public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        T valor = peek();
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.getLimite());

        for (int i = 0; i < tamanho; i++) {
            f3.inserir((T) info[i]);
        }
        for (int i = 0; i < f2.tamanho; i++) {
            f3.inserir((T) f2.info[i]);
        }

        return f3;
    }

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
    }

    public int getLimite() {
        return limite;
    }
}
