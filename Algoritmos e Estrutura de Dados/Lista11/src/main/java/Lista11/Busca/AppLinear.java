package Lista11.Busca;

import java.util.Arrays;

public class AppLinear {
    public static void main(String[] args) {
        String[] dados = {"maça", "banana", "laranja", "banana", "pera", "banana", "uva"};
        BuscaLinear<String> busca = new BuscaLinear<>();

        busca.setInfo(dados);

        System.out.println("Array: " + Arrays.toString(dados));

        System.out.println("buscar(\"banana\"): " + busca.buscar("banana")); // 1 (primeira ocorrência)
        System.out.println("buscarUltimaOcorrencia(\"banana\"): " + busca.buscarUltimaOcorrencia("banana")); // 5
        System.out.println("contarOcorrencias(\"banana\"): " + busca.contarOcorrencias("banana")); // 3

        int[] todas = busca.buscarTodos("banana");
        System.out.print("buscarTodos(\"banana\"): ");
        for (int i : todas) System.out.print(i + " ");
        System.out.println();

        System.out.println("existe(\"pera\"): " + busca.existe("pera")); // true
        System.out.println("existe(\"melancia\"): " + busca.existe("melancia")); // false

        System.out.println("buscarComLimite(\"banana\", 3): " + busca.buscarComLimite("banana", 3)); // 1
        System.out.println("buscarIgnoreCase(\"Pera\"): " + busca.buscarIgnoreCase("Pera")); // 4
        System.out.println("buscarPrimeiraDiferenca(\"banana\"): " + busca.buscarPrimeiraDiferenca("banana")); // 0 (maça != banana)
        System.out.println("buscarMaior(): " + busca.buscarMaior()); // índice do maior elemento (lexicograficamente "uva")

        String[] sub = {"banana", "pera", "banana"};
        System.out.println("buscarSubsequencia({\"banana\", \"pera\", \"banana\"}): " + busca.buscarSubsequencia(sub)); // 3
    }
}
