package Lista11.Busca;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract {

    public int buscar(T valor) {
        int n = getInfo().length;

        int inicio = 0;
        int fim = n - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];

            int comparacao = valor.compareTo(elemento); //o compareTo devolve um número positivo negativo ou zero, por isso a comparacao com 0 no if

            if (comparacao < 0) {
                fim = meio - 1;
            } else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                return meio; // achou
            }
        }

        return -1; // nao encontrado
    }

    // Busca binária para encontrar a primeira ocorrência (se houver repetidos)
    public int buscarPrimeiraOcorrencia(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];
            int comparacao = valor.compareTo(elemento);

            if (comparacao == 0) {
                resultado = meio;
                fim = meio - 1; // busca mais à esquerda
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return resultado;
    }

    // Busca binária para encontrar a última ocorrência (se houver repetidos)
    public int buscarUltimaOcorrencia(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];
            int comparacao = valor.compareTo(elemento);

            if (comparacao == 0) {
                resultado = meio;
                inicio = meio + 1; // busca mais à direita
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return resultado;
    }

    // Busca binária para encontrar o índice onde valor deve ser inserido (ordem crescente)
    public int buscarPosicaoInsercao(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n;

        while (inicio < fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (meio < n) ? (T) getInfo()[meio] : null;

            if (meio == n || valor.compareTo(elemento) <= 0) {
                fim = meio;
            } else {
                inicio = meio + 1;
            }
        }

        return inicio;
    }

    // Verifica se um valor existe usando busca binária (retorna boolean)
    public boolean existe(T valor) {
        return buscar(valor) != -1;
    }

    // Retorna o menor valor >= valor dado (ceil)
    public int buscarCeil(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];
            int cmp = elemento.compareTo(valor);

            if (cmp >= 0) {
                resultado = meio;
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return resultado;
    }

    // Retorna o maior valor <= valor dado (floor)
    public int buscarFloor(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];
            int cmp = elemento.compareTo(valor);

            if (cmp <= 0) {
                resultado = meio;
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return resultado;
    }

    // Busca binária recursiva
    public int buscarRecursiva(T valor) {
        return buscarRecursiva(valor, 0, getInfo().length - 1);
    }

    private int buscarRecursiva(T valor, int inicio, int fim) {
        if (inicio > fim) return -1;

        int meio = (inicio + fim) / 2;
        T elemento = (T) getInfo()[meio];
        int cmp = valor.compareTo(elemento);

        if (cmp == 0) return meio;
        else if (cmp < 0) return buscarRecursiva(valor, inicio, meio - 1);
        else return buscarRecursiva(valor, meio + 1, fim);
    }

    // Busca o número de ocorrências de valor em array ordenado (usa busca binária em ambas extremidades)
    public int contarOcorrencias(T valor) {
        int primeira = buscarPrimeiraOcorrencia(valor);
        if (primeira == -1) return 0;
        int ultima = buscarUltimaOcorrencia(valor);
        return ultima - primeira + 1;
    }

    // Busca o índice do menor elemento estritamente maior que o valor (successor)
    public int buscarSucessor(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];

            if (elemento.compareTo(valor) > 0) {
                resultado = meio;
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return resultado;
    }

    // Busca o índice do maior elemento estritamente menor que o valor (predecessor)
    public int buscarPredecessor(T valor) {
        int n = getInfo().length;
        int inicio = 0, fim = n - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];

            if (elemento.compareTo(valor) < 0) {
                resultado = meio;
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return resultado;
    }

    // Busca o índice do elemento mais próximo ao valor (menor distância)
    public int buscarMaisProximo(T valor) {
        int n = getInfo().length;
        if (n == 0) return -1;

        int inicio = 0, fim = n - 1;
        int melhorIndice = -1;
        long melhorDif = Long.MAX_VALUE;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            T elemento = (T) getInfo()[meio];

            long dif = diferencaAbs(valor, elemento);
            if (dif < melhorDif) {
                melhorDif = dif;
                melhorIndice = meio;
            }

            int cmp = valor.compareTo(elemento);
            if (cmp == 0) return meio;
            else if (cmp < 0) fim = meio - 1;
            else inicio = meio + 1;
        }

        return melhorIndice;
    }

    // Metodo auxiliar para calcular diferença absoluta (apenas para números)
    private long diferencaAbs(T a, T b) {
        if (a instanceof Number && b instanceof Number) {
            long va = ((Number) a).longValue();
            long vb = ((Number) b).longValue();
            return Math.abs(va - vb);
        }
        return Long.MAX_VALUE; // para tipos não numéricos
    }

    // Busca se o valor existe, e se não existir retorna o índice do maior valor menor que ele (floor ou -1)
    public int buscarOuFloor(T valor) {
        int pos = buscar(valor);
        if (pos != -1) return pos;
        return buscarFloor(valor);
    }
}