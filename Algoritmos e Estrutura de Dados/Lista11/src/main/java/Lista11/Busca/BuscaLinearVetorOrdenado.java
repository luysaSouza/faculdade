package Lista11.Busca;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract {

    public int buscar(T valor) {
        int n = getInfo().length;

        for (int i = 0; i < n-1; i++) {
            T elemento = (T) getInfo()[i];

            if (getInfo()[i].equals(valor)){
                return i;
            } if (valor.compareTo(elemento) < 0){
                break;
            }
        }

        return -1;
    }
}
