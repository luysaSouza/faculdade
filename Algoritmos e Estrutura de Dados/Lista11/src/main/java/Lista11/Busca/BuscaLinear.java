package Lista11.Busca;

import java.util.ArrayList;
import java.util.List;

public class BuscaLinear<T> extends BuscaAbstract {

    public int buscar(T valor) {
        int n = getInfo().length - 1;

        for (int i = 0; i < n; i++) {
            if (getInfo()[i].equals(valor)) { // encontrado
                return i;
            }
        }

        return -1; // nao encontrado
    }

    // Busca o índice da primeira ocorrência do valor
    public int buscarPrimeiraOcorrencia(T valor) {
        T[] info = (T[]) getInfo();
        int n = info.length;
        for (int i = 0; i < n; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    // Busca o índice da última ocorrência do valor
    public int buscarUltimaOcorrencia(T valor) {
        T[] info = (T[]) getInfo();
        for (int i = info.length - 1; i >= 0; i--) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    // Conta quantas vezes o valor aparece
    public int contarOcorrencias(T valor) {
        T[] info = (T[]) getInfo();
        int count = 0;
        for (T item : info) {
            if (item.equals(valor)) {
                count++;
            }
        }
        return count;
    }

    // Retorna um array com todos os índices onde o valor aparece
    public int[] buscarTodos(T valor) {
        T[] info = (T[]) getInfo();
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            if (info[i].equals(valor)) {
                indices.add(i);
            }
        }

        int[] resultado = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            resultado[i] = indices.get(i);
        }
        return resultado;
    }

    // Verifica se o valor existe na lista
    public boolean existe(T valor) {
        T[] info = (T[]) getInfo();
        for (T item : info) {
            if (item.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    // Busca e retorna índice + número de comparações feitas
    public ResultadoBusca buscarComContador(T valor) {
        T[] info = (T[]) getInfo();
        int comparacoes = 0;

        for (int i = 0; i < info.length; i++) {
            comparacoes++;
            if (info[i].equals(valor)) {
                return new ResultadoBusca(i, comparacoes);
            }
        }
        return new ResultadoBusca(-1, comparacoes);
    }

    // Classe interna para guardar resultado da busca com contador
    public static class ResultadoBusca {
        public int indice;
        public int comparacoes;

        public ResultadoBusca(int indice, int comparacoes) {
            this.indice = indice;
            this.comparacoes = comparacoes;
        }
    }

    //Busca o valor até um índice limite (ex: busca parcial).
    public int buscarComLimite(T valor, int limite) {
        T[] info = (T[]) getInfo();
        int n = Math.min(limite, info.length);
        for (int i = 0; i < n; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    //Busca linear ignorando maiúsculas/minúsculas, só para quando T for String.
    public int buscarIgnoreCase(String valor) {
        T[] info = (T[]) getInfo();
        for (int i = 0; i < info.length; i++) {
            if (info[i] instanceof String) {
                String s = (String) info[i];
                if (s.equalsIgnoreCase(valor)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Retorna o índice do primeiro elemento diferente do valor passado.
    public int buscarPrimeiraDiferenca(T valor) {
        T[] info = (T[]) getInfo();
        for (int i = 0; i < info.length; i++) {
            if (!info[i].equals(valor)) {
                return i;
            }
        }
        return -1; // todos iguais ao valor
    }

    //Retorna o índice do maior elemento segundo um comparador (supondo T seja Comparable).
    @SuppressWarnings("unchecked")
    public int buscarMaior() {
        T[] info = (T[]) getInfo();
        if (info.length == 0) return -1;
        int maiorIdx = 0;
        for (int i = 1; i < info.length; i++) {
            Comparable<T> c = (Comparable<T>) info[i];
            if (c.compareTo(info[maiorIdx]) > 0) {
                maiorIdx = i;
            }
        }
        return maiorIdx;
    }

    //Busca o índice onde a subsequência aparece (retorna o índice inicial ou -1 se não encontrado).
    public int buscarSubsequencia(T[] subsequencia) {
        T[] info = (T[]) getInfo();
        int n = info.length;
        int m = subsequencia.length;
        if (m == 0 || m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (!info[i + j].equals(subsequencia[j])) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
}
