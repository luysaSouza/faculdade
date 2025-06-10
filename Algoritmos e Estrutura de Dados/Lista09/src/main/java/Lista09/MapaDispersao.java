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

    //Verifica se uma chave está presente no mapa
    public boolean contemChave(int chave) {
        int indice = calcularHash(chave);
        if (info[indice] != null) {
            NoMapa<T> noBusca = new NoMapa<>();
            noBusca.setChave(chave);
            return info[indice].buscar(noBusca) != null;
        }
        return false;
    }

    //Retorna a quantidade total de elementos armazenados no mapa
    public int quantidadeElementos() {
        int total = 0;
        for (ListaEncadeada<NoMapa<T>> lista : info) {
            if (lista != null) {
                total += lista.obterComprimento();
            }
        }
        return total;
    }

    //Conta quantos índices do vetor possuem mais de um elemento (indicando colisões).
    public int contarColisoes() {
        int colisoes = 0;
        for (ListaEncadeada<NoMapa<T>> lista : info) {
            if (lista != null && lista.obterComprimento() > 1) {
                colisoes++;
            }
        }
        return colisoes;
    }

    //Exibe todos os elementos armazenados no mapa (útil para testes e debug).
    public void exibirMapa() {
        for (int i = 0; i < info.length; i++) {
            System.out.print("[" + i + "]: ");
            if (info[i] != null) {
                NoLista<NoMapa<T>> atual = info[i].getPrimeiro();
                while (atual != null) {
                    System.out.print("(" + atual.getInfo().getChave() + " -> " + atual.getInfo().getValor() + ") ");
                    atual = atual.getProximo();
                }
            }
            System.out.println();
        }
    }

    //Retorna o maior número de elementos encontrados em uma única lista (índice com mais colisões).
    public int tamanhoMaximoLista() {
        int max = 0;
        for (ListaEncadeada<NoMapa<T>> lista : info) {
            if (lista != null) {
                max = Math.max(max, lista.obterComprimento());
            }
        }
        return max;
    }
}
