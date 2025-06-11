package Lista10;

import java.util.Arrays;

public class AppQuick {
    public static void main(String[] args) {
        Integer[] dados = {8, 3, 5, 2, 9, 1, 4, 7, 6, 0};
        OrdenacaoQuickSort<Integer> quick = new OrdenacaoQuickSort<>();
        quick.setInfo(dados.clone());

        System.out.println(">>> Array original:");
        quick.exibirArray();

        // 1. Ordenar
        System.out.println("\n>>> Ordenando:");
        quick.ordenar();
        quick.exibirArray();

        // 2. Está ordenado?
        System.out.println("Está ordenado? " + quick.estaOrdenado());

        // 3. Comparações realizadas
        quick.setInfo(dados.clone());
        int comparacoes = quick.contarComparacoes();
        System.out.println("\nComparações feitas: " + comparacoes);

        // 4. Maior e menor valores
        System.out.println("\nMaior valor: " + quick.buscarMaiorValor());
        System.out.println("Menor valor: " + quick.buscarMenorValor());

        // 5. Índices do maior e menor
        System.out.println("Índice do maior valor: " + quick.indiceMaiorElemento());
        System.out.println("Índice do menor valor: " + quick.indiceMenorElemento());

        // 6. Obter mediana
        System.out.println("Mediana: " + quick.obterMediana());

        // 7. Cópia ordenada
        quick.setInfo(dados.clone());
        Integer[] copiaOrdenada = quick.obterArrayOrdenadoCopia();
        System.out.println("\nCópia ordenada: " + Arrays.toString(copiaOrdenada));

        // 8. Inverter array
        quick.setInfo(dados.clone());
        System.out.println("\nArray antes de inverter:");
        quick.exibirArray();
        quick.inverterArray();
        System.out.println("Array invertido:");
        quick.exibirArray();

        // 9. Ordenar decrescente
        quick.setInfo(dados.clone());
        quick.ordenarDecrescente();
        System.out.println("\nArray ordenado decrescente:");
        quick.exibirArray();

        // 10. Embaralhar
        quick.setInfo(dados.clone());
        System.out.println("\nArray antes de embaralhar:");
        quick.exibirArray();
        quick.embaralharArray();
        System.out.println("Array embaralhado:");
        quick.exibirArray();

        // 11. Ordenar parcialmente (índices 2 a 6)
        quick.setInfo(dados.clone());
        System.out.println("\nArray antes da ordenação parcial (2 a 6):");
        quick.exibirArray();
        quick.ordenarParcial(2, 6);
        System.out.println("Array após ordenar parcialmente:");
        quick.exibirArray();

        // 12. Posição e ocorrência de elementos
        quick.setInfo(dados.clone());
        System.out.println("\nPosição do valor 5: " + quick.posicaoElemento(5));
        System.out.println("Ocorrências do valor 3: " + quick.contarOcorrencias(3));
    }
}