package Lista11.Busca;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract{

    public int buscar(T valor) {
        int n = getInfo().length;

        int inicio = 0;
        int fim = n-1;

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
}
