package Lista10;

public class OrdenacaoBolha <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int i;
        int j;
        int n = getInfo().length; // n = size(info)

        for (i = n-1; i >= 1; i--) {
            for (j = 0; j <= i-1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j+1]) > 0) { // se (info[j] > info[j+1]) entao
                    trocar(j, j+1);
                }
            }
        }
    }
}
