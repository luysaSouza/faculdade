package Lista11.ArvoreBinariaBusca;

import java.util.ArrayList;
import java.util.List;

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
            if (info.compareTo(p.getInfo()) < 0) { // se (info < p.info) entao
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }

        return p;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // localizar o nó a ser removido
        while (p != null && p.getInfo() != info) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) {
            if (p.getEsquerda() == null && p.getDireita() == null) { // identifica que está a remover uma folha
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            } else {
                if (p.getDireita() == null) {
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {
                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                } else {
                    if (p.getEsquerda() == null) {
                        if (p == getRaiz()) {
                            setRaiz(p.getDireita());
                        } else {
                            if (filhoEsquerda) {
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else { // nó com dois filhos
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);

                        if (p == getRaiz()) {
                            setRaiz(sucessor);
                        } else {
                            if (filhoEsquerda) {
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);
                            }
                        }

                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != p.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }

    // Retorna o menor valor (mais à esquerda)
    public T minimo() {
        if (getRaiz() == null) return null;
        NoArvoreBinaria<T> atual = getRaiz();
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual.getInfo();
    }

    // Retorna o maior valor (mais à direita)
    public T maximo() {
        if (getRaiz() == null) return null;
        NoArvoreBinaria<T> atual = getRaiz();
        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }
        return atual.getInfo();
    }

    // Retorna a altura da árvore
    public int altura() {
        return altura(getRaiz());
    }

    private int altura(NoArvoreBinaria<T> no) {
        if (no == null) return -1;
        int altEsq = altura(no.getEsquerda());
        int altDir = altura(no.getDireita());
        return 1 + Math.max(altEsq, altDir);
    }

    // Retorna true se a árvore for uma BST(está corretamente ordenada) válida
    public boolean ehABB() {
        return ehABB(getRaiz(), null, null);
    }

    private boolean ehABB(NoArvoreBinaria<T> no, T min, T max) {
        if (no == null) return true;
        if ((min != null && no.getInfo().compareTo(min) <= 0) ||
                (max != null && no.getInfo().compareTo(max) >= 0)) {
            return false;
        }
        return ehABB(no.getEsquerda(), min, no.getInfo()) &&
                ehABB(no.getDireita(), no.getInfo(), max);
    }

    // Conta a quantidade de nós folha
    public int contarFolhas() {
        return contarFolhas(getRaiz());
    }

    private int contarFolhas(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
    }

    // Conta o número total de nós na árvore
    public int contarNos() {
        return contarNos(getRaiz());
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }

    // Conta os nós internos (com pelo menos 1 filho)
    public int contarNosInternos() {
        return contarNosInternos(getRaiz());
    }

    private int contarNosInternos(NoArvoreBinaria<T> no) {
        if (no == null || (no.getEsquerda() == null && no.getDireita() == null)) return 0;
        return 1 + contarNosInternos(no.getEsquerda()) + contarNosInternos(no.getDireita());
    }

    // Retorna true se a árvore estiver vazia
    public boolean estaVazia() {
        return getRaiz() == null;
    }

    // Retorna o nível de um nó (nível da raiz é 0)
    public int nivel(T valor) {
        return nivel(getRaiz(), valor, 0);
    }

    private int nivel(NoArvoreBinaria<T> no, T valor, int nivel) {
        if (no == null) return -1;
        if (no.getInfo().equals(valor)) return nivel;

        int nivelEsq = nivel(no.getEsquerda(), valor, nivel + 1);
        if (nivelEsq != -1) return nivelEsq;

        return nivel(no.getDireita(), valor, nivel + 1);
    }

    // Verifica se um nó é folha (sem filhos)
    public boolean ehFolha(T valor) {
        NoArvoreBinaria<T> no = buscar(valor);
        return no != null && no.getEsquerda() == null && no.getDireita() == null;
    }

    // Soma todos os valores da árvore (válido apenas para tipos numéricos)
    public int somarValores() {
        return somarValores(getRaiz());
    }

    private int somarValores(NoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return ((Integer) no.getInfo()) + somarValores(no.getEsquerda()) + somarValores(no.getDireita());
    }

    // Retorna o nó pai de um determinado valor
    public NoArvoreBinaria<T> buscarPai(T valor) {
        if (getRaiz() == null || getRaiz().getInfo().equals(valor)) return null;

        return buscarPai(getRaiz(), valor);
    }

    private NoArvoreBinaria<T> buscarPai(NoArvoreBinaria<T> no, T valor) {
        if (no == null) return null;

        if ((no.getEsquerda() != null && no.getEsquerda().getInfo().equals(valor)) ||
                (no.getDireita() != null && no.getDireita().getInfo().equals(valor))) {
            return no;
        }

        if (valor.compareTo(no.getInfo()) < 0) {
            return buscarPai(no.getEsquerda(), valor);
        } else {
            return buscarPai(no.getDireita(), valor);
        }
    }

    // Retorna o número de nós em um nível específico
    public int contarNosNoNivel(int nivel) {
        return contarNosNoNivel(getRaiz(), nivel, 0);
    }

    private int contarNosNoNivel(NoArvoreBinaria<T> no, int alvo, int atual) {
        if (no == null) return 0;
        if (atual == alvo) return 1;

        return contarNosNoNivel(no.getEsquerda(), alvo, atual + 1) +
                contarNosNoNivel(no.getDireita(), alvo, atual + 1);
    }

    // Retorna o sucessor (menor valor maior que o dado)
    public T buscarSucessor(T valor) {
        NoArvoreBinaria<T> atual = getRaiz();
        NoArvoreBinaria<T> sucessor = null;

        while (atual != null) {
            if (valor.compareTo(atual.getInfo()) < 0) {
                sucessor = atual;
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        return sucessor != null ? sucessor.getInfo() : null;
    }

    // Retorna o predecessor (maior valor menor que o dado)
    public T buscarPredecessor(T valor) {
        NoArvoreBinaria<T> atual = getRaiz();
        NoArvoreBinaria<T> predecessor = null;

        while (atual != null) {
            if (valor.compareTo(atual.getInfo()) > 0) {
                predecessor = atual;
                atual = atual.getDireita();
            } else {
                atual = atual.getEsquerda();
            }
        }

        return predecessor != null ? predecessor.getInfo() : null;
    }

    public boolean ehBalanceada() {
        return verificarBalanceamento(getRaiz()) != -1;
    }

    // Retorna -1 se estiver desbalanceada, senão retorna altura
    private int verificarBalanceamento(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }

        int alturaEsquerda = verificarBalanceamento(no.getEsquerda());
        if (alturaEsquerda == -1) return -1; // subárvore esquerda desbalanceada

        int alturaDireita = verificarBalanceamento(no.getDireita());
        if (alturaDireita == -1) return -1; // subárvore direita desbalanceada

        if (Math.abs(alturaEsquerda - alturaDireita) > 1) {
            return -1; // desbalanceado
        }

        return 1 + Math.max(alturaEsquerda, alturaDireita); // retorna altura normal
    }

    public boolean ehDegenerada() {
        return ehDegenerada(getRaiz());
    }

    private boolean ehDegenerada(NoArvoreBinaria<T> no) {
        if (no == null) return true;

        NoArvoreBinaria<T> esq = no.getEsquerda();
        NoArvoreBinaria<T> dir = no.getDireita();

        if (esq != null && dir != null) {
            return false; // possui dois filhos → não é degenerada
        }

        // Continua verificando na subárvore que existe (se houver)
        return ehDegenerada(esq != null ? esq : dir);
    }

    //tranformar arvore em vetor ordenado
    public List<T> paraVetorOrdenado() {
        List<T> lista = new ArrayList<>();
        preencherListaOrdenada(getRaiz(), lista);
        return lista;
    }

    private void preencherListaOrdenada(NoArvoreBinaria<T> no, List<T> lista) {
        if (no != null) {
            preencherListaOrdenada(no.getEsquerda(), lista);
            lista.add(no.getInfo());
            preencherListaOrdenada(no.getDireita(), lista);
        }
    }

    //Metodo para converter vetor ordenado em ABB
    public NoArvoreBinaria<T> vetorParaArvore(T[] vetor) {
        return vetorParaArvoreRec(vetor, 0, vetor.length - 1);
    }

    private NoArvoreBinaria<T> vetorParaArvoreRec(T[] vetor, int inicio, int fim) {
        if (inicio > fim) {
            return null;
        }

        int meio = (inicio + fim) / 2;
        NoArvoreBinaria<T> no = new NoArvoreBinaria<>(vetor[meio]);

        no.setEsquerda(vetorParaArvoreRec(vetor, inicio, meio - 1));
        no.setDireita(vetorParaArvoreRec(vetor, meio + 1, fim));

        return no;
    }

    public void construirArvoreDeVetor(T[] vetor) {
        setRaiz(vetorParaArvore(vetor));
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRec(getRaiz());
        System.out.println(); // só para pular linha no final
    }

    private void imprimirEmOrdemRec(NoArvoreBinaria<T> no) {
        if (no != null) {
            imprimirEmOrdemRec(no.getEsquerda());
            System.out.print(no.getInfo() + " ");
            imprimirEmOrdemRec(no.getDireita());
        }
    }
}







