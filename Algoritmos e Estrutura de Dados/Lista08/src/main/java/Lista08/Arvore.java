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
            qntNos += contarNos(p);
            p = p.getProximo();
        }

        return qntNos;
    }

    /**
     * Calcula a altura da árvore.
     * A altura é a maior distância entre a raiz e uma folha.
     *
     * @return A altura da árvore. Se a árvore estiver vazia, retorna -1.
     */
    public int altura() {
        if (raiz == null) {
            return -1; // árvore vazia
        } else {
            return altura(raiz);
        }
    }

    /**
     * Calcula a altura de um nó específico.
     * A altura de um nó é a maior distância entre esse nó e suas folhas.
     *
     * @param no O nó a partir do qual a altura será calculada.
     * @return A altura do nó.
     */
    private int altura(NoArvore<T> no) {
        if (no == null) {
            return -1; // caso base: no vazio
        }

        int alturaMaxima = -1;
        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            int alturaSubarvore = altura(p);
            alturaMaxima = Math.max(alturaMaxima, alturaSubarvore);
            p = p.getProximo();
        }

        return alturaMaxima + 1;
    }

    /**
     * Conta o número de folhas na árvore.
     * Folhas são os nós que não possuem filhos.
     *
     * @return O número de folhas na árvore. Se a árvore estiver vazia, retorna 0.
     */
    public int contarFolhas() {
        if (raiz == null) {
            return 0;
        } else {
            return contarFolhas(raiz);
        }
    }

    /**
     * Conta o número de folhas a partir de um nó específico.
     * Folhas são os nós que não possuem filhos.
     *
     * @param no O nó a partir do qual as folhas serão contadas.
     * @return O número de folhas no nó especificado.
     */
    private int contarFolhas(NoArvore<T> no) {
        if (no.getPrimeiro() == null) {
            return 1; // é uma folha
        }

        int qntFolhas = 0;
        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            qntFolhas += contarFolhas(p);
            p = p.getProximo();
        }

        return qntFolhas;
    }

    /**
     * Remove um nó da árvore com base no valor fornecido.
     *
     * @param info O valor do nó a ser removido.
     * @return true se o nó foi removido com sucesso, false caso contrário.
     */
    public boolean remover(T info) {
        if (raiz == null) {
            return false;
        }

        if (raiz.getInfo().equals(info)) {
            raiz = null; // remove a raiz
            return true;
        }

        return remover(raiz, info);
    }

    /**
     * Remove um nó específico a partir de um nó fornecido.
     *
     * @param no O nó a partir do qual a remoção será feita.
     * @param info O valor do nó a ser removido.
     * @return true se o nó foi removido com sucesso, false caso contrário.
     */
    private boolean remover(NoArvore<T> no, T info) {
        NoArvore<T> p = no.getPrimeiro();
        NoArvore<T> anterior = null;

        while (p != null) {
            if (p.getInfo().equals(info)) {
                if (anterior == null) {
                    no.setPrimeiro(p.getProximo()); // remove o primeiro nó
                } else {
                    anterior.setProximo(p.getProximo()); // remove nó intermediário
                }
                return true;
            }

            anterior = p;
            p = p.getProximo();
        }

        return false; // não encontrou
    }

    /**
     * Busca o nó de maior profundidade na árvore.
     * A profundidade é a maior distância entre a raiz e um nó folha.
     *
     * @return O nó de maior profundidade, ou null se a árvore estiver vazia.
     */
    public NoArvore<T> buscarMaiorProfundidade() {
        if (raiz == null) {
            return null;
        } else {
            return buscarMaiorProfundidade(raiz, 0, null, -1);
        }
    }

    /**
     * Busca o nó de maior profundidade a partir de um nó específico.
     *
     * @param no O nó a partir do qual a busca será realizada.
     * @param profundidade A profundidade atual.
     * @param maisProfundo O nó de maior profundidade encontrado até o momento.
     * @param maiorProfundidade A maior profundidade encontrada até o momento.
     * @return O nó de maior profundidade.
     */
    private NoArvore<T> buscarMaiorProfundidade(NoArvore<T> no, int profundidade, NoArvore<T> maisProfundo, int maiorProfundidade) {
        if (no == null) {
            return maisProfundo;
        }

        if (profundidade > maiorProfundidade) {
            maiorProfundidade = profundidade;
            maisProfundo = no;
        }

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            maisProfundo = buscarMaiorProfundidade(p, profundidade + 1, maisProfundo, maiorProfundidade);
            p = p.getProximo();
        }

        return maisProfundo;
    }

    /**
     * Encontra o nó pai de um determinado nó na árvore.
     *
     * @param info O valor do nó que desejamos encontrar o pai.
     * @return O nó pai do nó com o valor fornecido, ou null se o nó não tiver pai ou não existir.
     */
    public NoArvore<T> encontrarPai(T info) {
        if (raiz == null || raiz.getInfo().equals(info)) {
            return null; // A raiz não tem pai
        } else {
            return encontrarPai(raiz, info);
        }
    }

    /**
     * Encontra o nó pai de um determinado nó a partir de um nó específico.
     *
     * @param no O nó a partir do qual a busca será realizada.
     * @param info O valor do nó que desejamos encontrar o pai.
     * @return O nó pai do nó com o valor fornecido, ou null se não encontrado.
     */
    private NoArvore<T> encontrarPai(NoArvore<T> no, T info) {
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return no; // Encontramos o nó pai
            }
            NoArvore<T> pai = encontrarPai(p, info); // Recursão para os filhos
            if (pai != null) {
                return pai;
            }
            p = p.getProximo();
        }
        return null; // Nó não encontrado
    }

    /**
     * Busca o nó com o valor máximo na árvore.
     * Assumindo que os valores dos nós sejam comparáveis.
     *
     * @return O nó com o valor máximo, ou null se a árvore estiver vazia.
     */
    public NoArvore<T> buscarMaximo() {
        if (raiz == null) {
            return null;
        } else {
            return buscarMaximo(raiz);
        }
    }

    /**
     * Busca o nó com o valor máximo a partir de um nó específico.
     *
     * @param no O nó a partir do qual a busca será realizada.
     * @return O nó com o valor máximo.
     */
    private NoArvore<T> buscarMaximo(NoArvore<T> no) {
        NoArvore<T> p = no.getPrimeiro();
        NoArvore<T> maxNo = no;

        while (p != null) {
            NoArvore<T> maxFilho = buscarMaximo(p);
            if (((Comparable<T>) maxFilho.getInfo()).compareTo(maxNo.getInfo()) > 0) {
                maxNo = maxFilho;
            }
            p = p.getProximo();
        }

        return maxNo;
    }

    /**
     * Conta o número de nós em um nível específico da árvore.
     *
     * @param nivel O nível que será contado (onde a raiz é nível 0).
     * @return O número de nós no nível especificado.
     */
    public int contarNosNoNivel(int nivel) {
        if (raiz == null) {
            return 0;
        } else {
            return contarNosNoNivel(raiz, nivel, 0);
        }
    }

    /**
     * Conta o número de nós em um nível específico a partir de um nó dado.
     *
     * @param no O nó a partir do qual a contagem será feita.
     * @param nivel O nível a ser contado.
     * @param profundidade A profundidade atual do nó.
     * @return O número de nós no nível especificado.
     */
    private int contarNosNoNivel(NoArvore<T> no, int nivel, int profundidade) {
        if (no == null) {
            return 0;
        }

        int contagem = 0;
        if (profundidade == nivel) {
            contagem = 1; // Encontramos um nó no nível especificado
        }

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            contagem += contarNosNoNivel(p, nivel, profundidade + 1); // Percorre os filhos
            p = p.getProximo();
        }

        return contagem;
    }

    /**
     * Inverte a árvore.
     * A inversão faz com que as posições dos filhos sejam invertidas, ou seja,
     * a subárvore da esquerda passa a ser a da direita e vice-versa.
     */
    public void inverter() {
        if (raiz != null) {
            inverter(raiz);
        }
    }

    /**
     * Inverte a subárvore a partir de um nó específico.
     *
     * @param no O nó a partir do qual a inversão será realizada.
     */
    private void inverter(NoArvore<T> no) {
        NoArvore<T> p = no.getPrimeiro();
        NoArvore<T> anterior = null;
        NoArvore<T> proximo = null;

        // Inverter a lista de filhos
        while (p != null) {
            proximo = p.getProximo();
            p.setProximo(anterior);
            anterior = p;
            p = proximo;
        }

        no.setPrimeiro(anterior);

        // Recursivamente inverte os filhos
        p = no.getPrimeiro();
        while (p != null) {
            inverter(p);
            p = p.getProximo();
        }
    }
}
