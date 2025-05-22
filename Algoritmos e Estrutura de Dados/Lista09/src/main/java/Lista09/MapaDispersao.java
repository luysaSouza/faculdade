package Lista09;

public class MapaDispersao<T extends Comparable<T>>{

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setValor(dado);

        info[indice].inserir(noMapa); // inserir da ListaEncadeada
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            info[indice].retirar(noMapa); // retirar da ListaEncadeada
        }
    }

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

    public double calcularFatorCarga() {
        int totalElementos = 0;

        for (ListaEncadeada<NoMapa<T>> lista : info) {
            if (lista != null) {
                totalElementos += lista.obterComprimento(); // obterComprimento da ListaEncadeada
            }
        }

        return (double) totalElementos / info.length;
    }
}
