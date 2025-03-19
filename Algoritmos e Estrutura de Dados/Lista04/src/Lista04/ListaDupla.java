package Lista04;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * Inclui um novo dado na estrutura de dados
     *
     * @param valor Dado a ser inserido na lista encadeada
     */
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) { //se a lista nao esta vazia, vai executar esse comando
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    /**
     * Busca um elemento na lista duplamente encadeada
     *
     * @param valor Valor a ser localizado
     * @return Nó contendo o dado
     */
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    /**
     * Retira da estrutura de dados o elemento informado
     *
     * @param valor Valor a ser removido da lista duplamente encadeada
     */
    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        //codigo para atualizar o antecessor do elemento que estou removendo
        if (p != null) { //achou
            if (p == primeiro) { //primeiro elemento??
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            //codigo para atualizar o sucessor do elemento que estou removendo
            if (p.getProximo() != null) { //nao é o ultimo?
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    /**
     * Retorna o ultimo elemento da lista encadeada
     *
     * @return Nó armazenado na ultima posicao
     */
    private NoListaDupla<T> obterUltimo() {
        NoListaDupla<T> ultimo = primeiro;

        NoListaDupla<T> p = primeiro;
        while (p != null) {
            ultimo = p;
            p.getProximo();
        }

        return ultimo;
    }

    /**
     * Exibe o conteudo da lista encadeada começando a exibir primeiro o último
     * elemento
     */
    public void exibirOrdemInversa() {
        NoListaDupla<T> p = obterUltimo();

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    /**
     * Libera todos os nós da lista, removendo suas referências.
     */
    public void liberar() {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            p.setAnterior(null);
            NoListaDupla<T> sucessor = p.getProximo(); //garante o nó sucessor ao P, antes de atribuirmos null 
            p.setProximo(null);
            p = sucessor;
        }

        primeiro = null;
    }

    /**
     * 
     * @return 
     */
    public String toString() {
        String resultado = "";
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            if (p != primeiro) {
                resultado += ",";
            }
            resultado += p.getInfo();
            p = p.getProximo();
        }

        return resultado;
    }
}
