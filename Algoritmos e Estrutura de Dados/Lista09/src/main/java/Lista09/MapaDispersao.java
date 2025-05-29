package Lista09;

public class MapaDispersao<T>{

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    /**
     * Implementa a função de hash, que é responsavel por identificar
     * em que posição do vetor o objeto deve constar (ou ser armazenado)
     * @param chave Objeto a se calcular o hash
     * @return Hash calculado
     */
    private int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;

        //compacta
        //return (chave % info.length);
    }

    /**
     * Insere um objeto no mapa
     * @param dado Objeto a ser adicionado
     */
    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setValor(dado);

        info[indice].inserir(no); // inserir da ListaEncadeada
    }

    /**
     * Remove um objeto do mapa. O objeto fornecido como argumento
     * deve ter a chave de busca informado
     * @param chave Objeto que contem a chave de busca do objeto a ser removido
     */
    public void remover(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);

            info[indice].retirar(no); // retirar da ListaEncadeada
        }
    }

    /**
     * Busca e retorna o valor associado à chave especificada no mapa
     * @param chave a chave usada para buscar o valor correspondente
     * @return o valor associado à chave, ou {@code null} se a chave não estiver presente
     */
    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa); // buscar da ListaEncadeada

            if (no != null) {
                return no.getInfo().getValor();
            }
        }

        return null;
    }

    /**
     * Calcula o fator de carga do mapa de dispersão.
     * @return Fator de carga do mapa
     */
    public double calcularFatorCarga() {
        int qntDeObjetosAdicionados = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null)
                qntDeObjetosAdicionados += info[i].obterComprimento(); // obterComprimento da ListaEncadeada
        }

        return (1.0 * qntDeObjetosAdicionados) / info.length; // 1.0 torna o retorno em um numero decimal
    }
}
