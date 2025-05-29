package Lista11.ArvoreBinariaBusca;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);

        if (getRaiz() == null) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();

            while (true) {
                NoArvoreBinaria<T> pai = p;

                if (info.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();

                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();

                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = getRaiz();

        while (p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }

        return p;
    }
}
