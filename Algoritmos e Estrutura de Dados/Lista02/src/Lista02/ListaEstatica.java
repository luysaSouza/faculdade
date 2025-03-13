package Lista02;

public class ListaEstatica<T> {

    private Object[] info;
    private int tamanho;

    /**
     * Cria uma lista vazia
     */
    public ListaEstatica() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    /**
     * Provoca um pseudo resimensionamento do vetor info
     */
    private void redimensionar() {
        Object[] novo = new Object[info.length + 10];

        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    /**
     * Adiciona um valor na lista
     *
     * @param valor Dado a ser adicionado
     */
    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    /**
     * Exibe o conteudo da lista
     */
    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    /**
     * Porcura na lista um determinado valor
     *
     * @param valor Dado a ser pesquisado
     * @return posição do valor da lista. Caso nao seja encontrado retorna -1
     */
    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Retira um dado da lista
     *
     * @param valor Dado a ser removido
     */
    public void retirar(T valor) {
        int indiceRetirar = buscar(valor);

        if (indiceRetirar != -1) {
            for (int i = indiceRetirar; i < tamanho - 1; i++) { // OU for (int i = indiceRetirar+1; i < tamanho; i++) {
                info[i] = info[i + 1]; // OU info[i-1] = info[i];       
            }

            info[tamanho - 1] = null;
            tamanho--;
        }
    }

    /**
     * Limpa a estrutura de dados, de forma que a lista esteja vazia
     */
    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    /**
     * Retorna o dado armazenado nume determinada posição da lista
     *
     * @param posicao Posição do dado
     * @return Dado localizado
     */
    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("ERRO: indice fora do limite do vetor");
        }

        return (T) info[posicao];
    }

    /**
     * Verifica se a estrutura está vazia
     *
     * @return
     */
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o tamanho atual da lista.
     *
     * @return O número de elementos atualmente armazenados.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Retorna uma representação em string dos elementos armazenados na lista.
     * Os elementos são separados por vírgula.
     *
     * @return Uma string contendo os elementos armazenados, separados por
     * vírgula. Se a estrutura estiver vazia, retorna uma string vazia.
     */
    @Override
    public String toString() {
        String valores = "";

        for (int i = 0; i < tamanho; i++) {
            if (i == tamanho - 1) {
                valores += info[i];
            } else {
                valores += info[i] + ",";
            }
        }

        return valores;
    }

    /**
     * Inverte a ordem dos dados armazenados na lista
     */
    public void inverter() {
        for (int i = 0, auxiliar = tamanho-1; i < tamanho / 2; i++, auxiliar--) {
            Object valorTemp = info[i];  
            info[i] = info[auxiliar];  
            info[auxiliar] = valorTemp;  
        }
    }
}
