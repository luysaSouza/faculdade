package Lista10;

import java.util.Random;
import java.util.Arrays;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        mergeSort(0, getInfo().length-1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio+1, fim);
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int tamEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i <= tamEsquerda-1; i++){
            esquerda[i] = info[inicio + i];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i <= tamDireita-1; i++){
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;

        int i;
        for (i = inicio; i <= fim; i++) {
            if ((cEsq < tamEsquerda) && (cDir < tamDireita)) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) { // se (esquerda[cEsq] < direita[cDir]) entao
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }

        while (cEsq < tamEsquerda) {
            info[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }

        while (cDir < tamDireita) {
            info[i] = direita[cDir];
            cDir++;
            i++;
        }
    }

    //Exibe os elementos do array.
    public void exibirArray() {
        for (T elemento : getInfo()) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    //Verifica se o array está em ordem crescente.
    public boolean estaOrdenado() {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //Conta o número total de comparações feitas durante a ordenação (versão instrumentada).
    private int comparacoes = 0;

    public int contarComparacoes() {
        comparacoes = 0;
        mergeSortContando(0, getInfo().length - 1);
        return comparacoes;
    }

    private void mergeSortContando(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortContando(inicio, meio);
            mergeSortContando(meio + 1, fim);
            mergeContando(inicio, fim, meio);
        }
    }

    private void mergeContando(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int tamEsq = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsq];
        for (int i = 0; i < tamEsq; i++) {
            esquerda[i] = info[inicio + i];
        }

        int tamDir = fim - meio;
        T[] direita = (T[]) new Comparable[tamDir];
        for (int i = 0; i < tamDir; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0, cDir = 0, i = inicio;

        while (cEsq < tamEsq && cDir < tamDir) {
            comparacoes++;
            if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                info[i++] = esquerda[cEsq++];
            } else {
                info[i++] = direita[cDir++];
            }
        }

        while (cEsq < tamEsq) {
            info[i++] = esquerda[cEsq++];
        }

        while (cDir < tamDir) {
            info[i++] = direita[cDir++];
        }
    }

    //Inverte a ordem do array.
    public void inverterArray() {
        T[] vetor = getInfo();
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio < fim) {
            trocar(inicio, fim);
            inicio++;
            fim--;
        }
    }

    //Retorna uma cópia ordenada do array (sem alterar o original).
    public T[] obterArrayOrdenadoCopia() {
        T[] copia = getInfo().clone();
        OrdenacaoMergeSort<T> merge = new OrdenacaoMergeSort<>();
        merge.setInfo(copia);
        merge.ordenar();
        return copia;
    }

    //Retorna o maior valor presente no array.
    public T buscarMaiorValor() {
        T[] vetor = getInfo();
        T maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(maior) > 0) {
                maior = vetor[i];
            }
        }

        return maior;
    }

    //Retorna o menor valor presente no array.
    public T buscarMenorValor() {
        T[] vetor = getInfo();
        T menor = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(menor) < 0) {
                menor = vetor[i];
            }
        }

        return menor;
    }

    //Retorna o índice da primeira ocorrência de um valor.
    public int posicaoElemento(T valor) {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].compareTo(valor) == 0) {
                return i;
            }
        }
        return -1;
    }

    //Conta quantas vezes o valor aparece no array.
    public int contarOcorrencias(T valor) {
        int contador = 0;
        for (T elemento : getInfo()) {
            if (elemento.compareTo(valor) == 0) {
                contador++;
            }
        }
        return contador;
    }

    //Ordena apenas parte do array (subvetor entre inicio e fim).
    public void ordenarParcial(int inicio, int fim) {
        if (inicio >= 0 && fim < getInfo().length && inicio < fim) {
            mergeSort(inicio, fim);
        }
    }

    //Retorna o índice do maior valor do array.
    public int indiceMaiorElemento() {
        T[] vetor = getInfo();
        int indiceMaior = 0;

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(vetor[indiceMaior]) > 0) {
                indiceMaior = i;
            }
        }

        return indiceMaior;
    }

    //Retorna o índice do menor valor do array.
    public int indiceMenorElemento() {
        T[] vetor = getInfo();
        int indiceMenor = 0;

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(vetor[indiceMenor]) < 0) {
                indiceMenor = i;
            }
        }

        return indiceMenor;
    }

    //Mistura os elementos do array (útil para testes de desempenho).
    public void embaralharArray() {
        T[] vetor = getInfo();
        Random rand = new Random();

        for (int i = vetor.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            trocar(i, j);
        }
    }

    //Retorna o valor da mediana do array ordenado.
    public T obterMediana() {
        T[] copia = getInfo().clone();
        Arrays.sort(copia); // T extends Comparable<T>
        int meio = copia.length / 2;

        if (copia.length % 2 == 0) {
            return copia[meio - 1]; // ou media se numérico
        } else {
            return copia[meio];
        }
    }

    //Ordena o array em ordem decrescente.
    public void ordenarDecrescente() {
        ordenar();
        inverterArray();
    }

    //Verifica se um determinado valor está presente no array.
    public boolean contemElemento(T valor) {
        for (T elemento : getInfo()) {
            if (elemento.compareTo(valor) == 0) {
                return true;
            }
        }
        return false;
    }

    //Verifica se todos os elementos do vetor são iguais.
    public boolean ehTudoIgual() {
        T[] vetor = getInfo();
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(vetor[0]) != 0) {
                return false;
            }
        }
        return true;
    }

    //Verifica se o vetor está em ordem estritamente decrescente.
    public boolean ehDecrescente() {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    //Obs: esse último só faz sentido se T for Integer.
    //Gera um "histograma" com contagem de elementos de 0 até maxValor − 1 (útil se os valores forem inteiros pequenos).
    public int[] gerarHistograma(int maxValor) {
        int[] histograma = new int[maxValor];
        for (T elemento : getInfo()) {
            int valor = (Integer) elemento;
            if (valor >= 0 && valor < maxValor) {
                histograma[valor]++;
            }
        }
        return histograma;
    }
}
