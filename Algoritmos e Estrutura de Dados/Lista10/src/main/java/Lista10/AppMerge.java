package Lista10;

import java.util.Arrays;

public class AppMerge {
    public static void main(String[] args) {
        Integer[] dados = {8, 3, 5, 2, 9, 1, 4, 7, 6, 0};
        OrdenacaoMergeSort<Integer> merge = new OrdenacaoMergeSort<>();
        merge.setInfo(dados.clone());

        System.out.println(">>> Array original:");
        merge.exibirArray();

        // 1. Ordenar
        merge.ordenar();
        System.out.println("\nArray ordenado:");
        merge.exibirArray();

        // 2. Está ordenado?
        System.out.println("Está ordenado? " + merge.estaOrdenado());

        // 3. Comparações
        merge.setInfo(dados.clone());
        int comparacoes = merge.contarComparacoes();
        System.out.println("Comparações feitas: " + comparacoes);

        // 4. Maior e menor valores
        System.out.println("Maior valor: " + merge.buscarMaiorValor());
        System.out.println("Menor valor: " + merge.buscarMenorValor());

        // 5. Índices do maior e menor
        System.out.println("Índice do maior: " + merge.indiceMaiorElemento());
        System.out.println("Índice do menor: " + merge.indiceMenorElemento());

        // 6. Mediana
        System.out.println("Mediana: " + merge.obterMediana());

        // 7. Posição e ocorrência
        System.out.println("Posição do valor 5: " + merge.posicaoElemento(5));
        System.out.println("Ocorrências do valor 3: " + merge.contarOcorrencias(3));

        // 8. Cópia ordenada
        Integer[] copia = merge.obterArrayOrdenadoCopia();
        System.out.println("Cópia ordenada: " + Arrays.toString(copia));

        // 9. Inverter array
        merge.setInfo(dados.clone());
        merge.inverterArray();
        System.out.println("\nArray invertido:");
        merge.exibirArray();

        // 10. Ordenar parcialmente
        merge.setInfo(dados.clone());
        System.out.println("\nAntes de ordenar parcialmente (2 a 6):");
        merge.exibirArray();
        merge.ordenarParcial(2, 6);
        System.out.println("Após ordenação parcial:");
        merge.exibirArray();

        // 11. Embaralhar
        merge.setInfo(dados.clone());
        merge.embaralharArray();
        System.out.println("\nArray embaralhado:");
        merge.exibirArray();

        // 12. Ordenar decrescente
        merge.setInfo(dados.clone());
        merge.ordenarDecrescente();
        System.out.println("Array ordenado decrescente:");
        merge.exibirArray();

        // 13. Verifica se contém um elemento
        merge.setInfo(dados.clone());
        System.out.println("\nContém o número 4? " + merge.contemElemento(4));
        System.out.println("Contém o número 100? " + merge.contemElemento(100));

        merge.exibirArray();
        System.out.println("Todos os elementos são iguais? " + merge.ehTudoIgual());

        // 14. Verifica se array está em ordem decrescente
        merge.setInfo(new Integer[]{9, 7, 5, 3, 1});
        System.out.println("\nArray manualmente decrescente:");
        merge.exibirArray();
        System.out.println("Está decrescente? " + merge.ehDecrescente());

        // 15. Gerar histograma
        merge.setInfo(new Integer[]{1, 3, 1, 2, 3, 2, 3});
        System.out.println("\nHistograma de valores de 0 a 4:");
        int[] histograma = merge.gerarHistograma(5);
        System.out.println(Arrays.toString(histograma));
    }
}
