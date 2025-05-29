package Lista11.ArvoreBinariaBusca;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        if (info.equals(no.getInfo())) {
            return no;
        } else if (((Comparable<T>) info).compareTo(no.getInfo()) < 0) {
            return buscar(no.getEsquerda(), info);
        } else {
            return buscar(no.getDireita(), info);
        }
    }
}
