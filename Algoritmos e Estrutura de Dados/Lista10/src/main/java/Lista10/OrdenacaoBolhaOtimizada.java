package Lista10;

public class OrdenacaoBolhaOtimizada <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = getInfo();
        int i;
        int j;
        int n = info.length;

        for (i = n-1; i >= 1; i--) {
            boolean trocou = false;
            for (j = 0; j <= i-1; j++) {
                if (info[j].compareTo(info[j+1]) > 0) {
                    trocar(j, j+1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
}
