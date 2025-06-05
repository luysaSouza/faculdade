package Lista11.Busca;

public class BuscaLinear<T> extends BuscaAbstract{

    public int buscar(T valor) {
        int n = getInfo().length-1;

        for (int i = 0; i < n; i++) {
            if (getInfo()[i].equals(valor)){ // encontrado
                return i;
            }
        }

        return -1; // nao encontrado
    }
}
