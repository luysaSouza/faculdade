package Lista10;

public abstract class OrdenacaoAbstract <T extends Comparable<T>> {

    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    /**
     * Troca a posição de dois dados
     * @param a Posição de um dos dados
     * @param b Posição de outro dado
     */
    public void trocar (int a, int b) {
        T backup;
        backup = info[a];
        info[a] = info[b];
        info[b] = backup;
    }

    /**
     * Ordena os dados do vetor info
     */
    public abstract void ordenar();
}
