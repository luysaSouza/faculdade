package Lista11.Busca;

public class AppBinaria {

    public static void main(String[] args) {
        Integer[] dados = {1, 3, 3, 5, 7, 8, 8, 10, 15, 20};

        BuscaBinaria<Integer> busca = new BuscaBinaria<>();
        busca.setInfo(dados);  // assumindo que setInfo() existe na BuscaAbstract para definir o array

        int valor = 8;

        System.out.println("Array: ");
        for (Integer v : dados) System.out.print(v + " ");
        System.out.println("\n");

        System.out.println("Buscar valor " + valor + ": índice = " + busca.buscar(valor));
        System.out.println("Buscar primeira ocorrência de " + valor + ": índice = " + busca.buscarPrimeiraOcorrencia(valor));
        System.out.println("Buscar última ocorrência de " + valor + ": índice = " + busca.buscarUltimaOcorrencia(valor));
        System.out.println("Buscar posição para inserção de " + valor + ": índice = " + busca.buscarPosicaoInsercao(valor));
        System.out.println("Verificar se " + valor + " existe: " + busca.existe(valor));
        System.out.println("Buscar ceil de " + valor + ": índice = " + busca.buscarCeil(valor));
        System.out.println("Buscar floor de " + valor + ": índice = " + busca.buscarFloor(valor));
        System.out.println("Buscar recursiva para " + valor + ": índice = " + busca.buscarRecursiva(valor));
        System.out.println("Contar ocorrências de " + valor + ": " + busca.contarOcorrencias(valor));
        System.out.println("Buscar sucessor de " + valor + ": índice = " + busca.buscarSucessor(valor));
        System.out.println("Buscar predecessor de " + valor + ": índice = " + busca.buscarPredecessor(valor));
        System.out.println("Buscar mais próximo de " + valor + ": índice = " + busca.buscarMaisProximo(valor));
        System.out.println("Buscar ou floor de " + (valor + 2) + ": índice = " + busca.buscarOuFloor(valor + 2));
    }
}
