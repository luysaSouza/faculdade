package Lista08;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore (){
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString (){
        if (raiz == null){
            return "<>";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        String resultado = "<";

        resultado += no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while (p != null){
            resultado += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        resultado += ">";

        return resultado;
    }

    public boolean pertence(T info){
        if (raiz == null){
            return false;
        } else {
            return pertence(raiz, info);
        }
    }

    private boolean pertence(NoArvore<T> no, T info){
        if (no.getInfo().equals(info)){
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();

            while (p != null) {
                if (pertence(p, info)){
                    return true;
                }
                p = p.getProximo();
            }
        }
        return false;
    }

    public int contarNos(){
        if (raiz == null){
            return 0;
        } else {
            return contarNos(raiz);
        }
    }

    private int contarNos(NoArvore<T> no){
        int qntNos = 1;

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            contarNos(p);
            qntNos++;
            p = p.getProximo();
        }

        return qntNos;
    }
}
