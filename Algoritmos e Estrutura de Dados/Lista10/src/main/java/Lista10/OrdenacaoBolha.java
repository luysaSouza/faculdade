package Lista10;

import java.util.Random;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int i;
        int j;
        int n = getInfo().length; // n = size(info)

        for (i = n - 1; i >= 1; i--) {
            for (j = 0; j <= i - 1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) { // se (info[j] > info[j+1]) entao
                    trocar(j, j + 1);
                }
            }
        }
    }

    //Conta quantas comparações são feitas durante a ordenação.
    public int contarComparacoes() {
        int comparacoes = 0;
        int n = getInfo().length;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                comparacoes++;
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }

        return comparacoes;
    }

    //Conta quantas trocas são realizadas durante a ordenação.
    public int contarTrocas() {
        int trocas = 0;
        int n = getInfo().length;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocas++;
                }
            }
        }

        return trocas;
    }

    //Verifica se o vetor já está ordenado em ordem crescente.
    public boolean estaOrdenado() {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //Mostra todos os elementos do array antes ou depois da ordenação.
    public void exibirArray() {
        for (T elemento : getInfo()) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    //Retorna o índice do maior elemento do array.
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

    //Retorna o índice do menor elemento do array.
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

    //Retorna uma cópia ordenada do vetor original, sem alterar o vetor interno.
    public T[] obterArrayOrdenadoCopia() {
        T[] copia = getInfo().clone();

        for (int i = copia.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (copia[j].compareTo(copia[j + 1]) > 0) {
                    T temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                }
            }
        }

        return copia;
    }

    //Ordena o vetor em ordem decrescente (inversa da padrão).
    public void ordenarDecrescente() {
        int n = getInfo().length;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) < 0) { // inverte a condição
                    trocar(j, j + 1);
                }
            }
        }
    }

    //Embaralha os elementos do vetor (bom para testar várias ordens iniciais).

    public void embaralharArray() {
        T[] vetor = getInfo();
        Random rand = new Random();

        for (int i = vetor.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            trocar(i, j);
        }
    }

    //Retorna a posição (índice) do elemento especificado no array.
    public int posicaoElemento(T valor) {
        T[] vetor = getInfo();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].compareTo(valor) == 0) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    //Conta quantas vezes um valor aparece no array.
    public int contarOcorrencias(T valor) {
        int contador = 0;
        for (T elemento : getInfo()) {
            if (elemento.compareTo(valor) == 0) {
                contador++;
            }
        }
        return contador;
    }

    //Retorna o maior valor do vetor.
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

    //Retorna o menor valor do vetor.
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

    //Ordena apenas uma parte do vetor (de inicio até fim, inclusive).
    public void ordenarParcial(int inicio, int fim) {
        T[] vetor = getInfo();

        if (inicio < 0 || fim >= vetor.length || inicio >= fim) return;

        for (int i = fim; i > inicio; i--) {
            for (int j = inicio; j < i; j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
