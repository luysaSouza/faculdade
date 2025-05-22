package Lista09;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    /**
     * Construtor padrão da classe ListaEncadeada
     *
     */
    public ListaEncadeada() {
        this.primeiro = null;
    }

    /**
     * Getter da variável primeiro
     *
     * @return Primeiro nó da lista
     */
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * Insere um novo valor na lista
     *
     * @param valor Valor a ser inserido na lista
     */
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    /**
     * Avalia se a lista está vazia ou não
     *
     * @return True se a lista estiver vazia
     */
    public boolean estaVazia() {
        return this.primeiro == null;
    }

    /**
     * Exibe os elementos da lista encadeada
     *
     */
    public void exibir() {
        NoLista<T> p = primeiro;

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    /**
     * Busca um nó na lista encadeada
     *
     * @param valor Dado a ser localizado
     * @return Nó contendo o dado localizado
     */
    public NoLista<T> buscar(T valor) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    /**
     * Retira um dado da lista encadeada
     *
     * @param valor Dado a ser retirado da lista encadeada
     */
    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(valor))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    /**
     * Calcula a quantidade de nós da lista
     *
     * @return Quantidade de elementos da lista
     */
    public int obterComprimento() {
        int qntNos = 0;
        NoLista<T> p = primeiro;

        while (p != null) { //A quantidade de interações desse laço é igual a quantidade de nós
            qntNos++;
            p = p.getProximo();
        }

        return qntNos;
    }

    public NoLista<T> obterNo(int idx) {
        /*
        MEU
        if ((idx < 0) || (idx >= obterComprimento())) {
            throw new IndexOutOfBoundsException("ERRO: indice fora do limite do vetor");
        }
         */
        if (idx < 0) {
            throw new IndexOutOfBoundsException("ERRO: indice fora do limite do vetor");
        }

        NoLista<T> p = getPrimeiro();

        /*
        MEU
        for (int i = 0; i < idx; i++) {
            p = p.getProximo();
        }
         */
        while ((p != null) && (idx > 0)) {
            idx--;
            p = p.getProximo();
        }

        if (p == null) {
            throw new IndexOutOfBoundsException("ERRO: indice fora do limite do vetor");

        }

        return p;
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
        String resultado = "";
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p != primeiro) {
                resultado += ",";
            }
            resultado += p.getInfo();
            p = p.getProximo();
        }

        return resultado;
    }

    /**
     * Cria e retorna uma nova lista encadeada contendo os mesmos elementos da
     * lista original, mas ordem contrária.
     *
     * @return uma nova lista contendo os mesmos elementos da lista original, porém na ordem contrária
     */
    public ListaEncadeada<T> criarInvertida() {
        ListaEncadeada<T> nova = new ListaEncadeada<>();
        NoLista<T> p = primeiro;

        while (p != null) {
            nova.inserir(p.getInfo());
            p = p.getProximo();
        }

        return nova;
    }
}
