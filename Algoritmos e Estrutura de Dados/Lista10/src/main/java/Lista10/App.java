package Lista10;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] dados = { 8, 3, 5, 2, 9, 1, 4, 7, 6, 0 };
        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();
        ordenacao.setInfo(dados);

        System.out.println(">>> Array original:");
        ordenacao.exibirArray();

        // 1. Ordenar
        System.out.println("\n>>> Ordenando...");
        ordenacao.ordenar();
        ordenacao.exibirArray();

        // 2. Está ordenado?
        System.out.println("\nEstá ordenado? " + ordenacao.estaOrdenado());

        // 3. Embaralhar e mostrar
        System.out.println("\n>>> Embaralhar:");
        ordenacao.embaralharArray();
        ordenacao.exibirArray();

        // 4. Contar comparações
        ordenacao.setInfo(dados.clone());
        int comparacoes = ordenacao.contarComparacoes();
        System.out.println("\nComparações feitas: " + comparacoes);

        // 5. Contar trocas
        ordenacao.setInfo(dados.clone());
        int trocas = ordenacao.contarTrocas();
        System.out.println("Trocas feitas: " + trocas);

        // 6. Maior e menor valores
        System.out.println("\nMaior valor: " + ordenacao.buscarMaiorValor());
        System.out.println("Menor valor: " + ordenacao.buscarMenorValor());

        // 7. Índices do maior e menor
        System.out.println("Índice do maior: " + ordenacao.indiceMaiorElemento());
        System.out.println("Índice do menor: " + ordenacao.indiceMenorElemento());

        // 8. Ordenar decrescente
        System.out.println("\n>>> Ordenar decrescente:");
        ordenacao.ordenarDecrescente();
        ordenacao.exibirArray();

        // 9. Obter array ordenado (sem alterar original)
        System.out.println("\n>>> Cópia ordenada (sem alterar o original):");
        Integer[] copiaOrdenada = ordenacao.obterArrayOrdenadoCopia();
        System.out.println(Arrays.toString(copiaOrdenada));

        // 10. Buscar posição de um valor
        System.out.println("\nPosição do valor 5: " + ordenacao.posicaoElemento(5));

        // 11. Contar ocorrências
        System.out.println("Ocorrências do valor 3: " + ordenacao.contarOcorrencias(3));

        // 12. Ordenar parcialmente
        ordenacao.setInfo(new Integer[]{ 8, 3, 5, 2, 9, 1, 4, 7, 6, 0 });
        System.out.println("\n>>> Array antes da ordenação parcial (2 a 6):");
        ordenacao.exibirArray();
        ordenacao.ordenarParcial(2, 6);
        System.out.println("Array após ordenar parcialmente:");
        ordenacao.exibirArray();
    }
}
