package Lista10;

import java.util.Arrays;
import java.util.Random;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] info = getInfo();

        int a = inicio;
        int b = fim + 1;

        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0); // info[a] < pivo

            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0); // pivo > info[b]

            if (a >= b) {
                break;
            }

            trocar(a, b);
        }

        trocar(b, inicio);

        return b;
    }

    //Exibe todos os elementos do vetor.
    public void exibirArray() {
        for (T elemento : getInfo()) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    //Verifica se o array está ordenado em ordem crescente.
    public boolean estaOrdenado() {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //Conta quantas comparações são feitas durante a ordenação (versão instrumentada do particionar).
    private int comparacoes = 0;

    public int contarComparacoes() {
        comparacoes = 0;
        quickSortComparacoes(0, getInfo().length - 1);
        return comparacoes;
    }

    private void quickSortComparacoes(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionarContando(inicio, fim);
            quickSortComparacoes(inicio, indicePivo - 1);
            quickSortComparacoes(indicePivo + 1, fim);
        }
    }

    private int particionarContando(int inicio, int fim) {
        T[] info = getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            do {
                a++;
                comparacoes++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            do {
                b--;
                comparacoes++;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }
            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }

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

    //Ordena em ordem decrescente (alterando a lógica de comparação).
    public void ordenarDecrescente() {
        quickSortDecrescente(0, getInfo().length - 1);
    }

    private void quickSortDecrescente(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionarDecrescente(inicio, fim);
            quickSortDecrescente(inicio, indicePivo - 1);
            quickSortDecrescente(indicePivo + 1, fim);
        }
    }

    private int particionarDecrescente(int inicio, int fim) {
        T[] info = getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) > 0); // > para decrescente

            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) < 0); // < para decrescente

            if (a >= b) break;

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }

    //Mistura os elementos (ótimo para testes).
    public void embaralharArray() {
        T[] vetor = getInfo();
        Random rand = new Random();

        for (int i = vetor.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            trocar(i, j);
        }
    }

    //Ordena apenas um trecho do vetor.
    public void ordenarParcial(int inicio, int fim) {
        if (inicio >= 0 && fim < getInfo().length && inicio < fim) {
            quickSort(inicio, fim);
        }
    }

    //Retorna a posição de um valor no vetor.
    public int posicaoElemento(T valor) {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].compareTo(valor) == 0) {
                return i;
            }
        }
        return -1;
    }

    //Conta quantas vezes um valor aparece.
    public int contarOcorrencias(T valor) {
        int contador = 0;
        for (T elemento : getInfo()) {
            if (elemento.compareTo(valor) == 0) {
                contador++;
            }
        }
        return contador;
    }

    //Retorna o índice do maior elemento do vetor.
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

    //Retorna o índice do menor elemento do vetor.
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

    //Retorna o valor central (mediana) do vetor ordenado (útil para análise).
    public T obterMediana() {
        T[] vetor = getInfo().clone();
        Arrays.sort(vetor);
        int meio = vetor.length / 2;

        if (vetor.length % 2 == 0) {
            return vetor[meio - 1]; // retorna o menor dos centrais
        } else {
            return vetor[meio];
        }
    }

    //Retorna uma cópia do vetor ordenado (sem modificar o original).
    public T[] obterArrayOrdenadoCopia() {
        T[] copia = getInfo().clone();
        OrdenacaoQuickSort<T> quick = new OrdenacaoQuickSort<>();
        quick.setInfo(copia);
        quick.ordenar();
        return copia;
    }

    //Inverte a ordem dos elementos do vetor.
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
}
