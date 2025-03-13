package Lista04;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

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

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) { //achou
            if (p == primeiro) { //primeiro elemento??
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) { //nao é o ultimo?
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = primeiro;
        
        while (p.getProximo() != null) {
            p = p.getProximo();
        }

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            p.setAnterior(null);
            p.setProximo(null);
            p = p.getProximo();
        }

        primeiro = null;
    }

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
