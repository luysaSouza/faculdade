package Lista09;

public class App {

    public static void main(String[] args) {
        // Cria um mapa com 5 posições (tamanho da tabela hash)
        MapaDispersao<String> mapa = new MapaDispersao<>(5);

        // Inserção de pares chave-valor
        mapa.inserir(1, "Banana");
        mapa.inserir(6, "Maçã");   // Mesmo índice de 1 se tamanho for 5
        mapa.inserir(3, "Laranja");
        mapa.inserir(8, "Pera");

        // Testa busca
        System.out.println("Buscar chave 6: " + mapa.buscar(6));  // Deve imprimir "Maçã"
        System.out.println("Buscar chave 2: " + mapa.buscar(2));  // Deve imprimir null

        // Testa fator de carga
        System.out.printf("Fator de carga: %.2f%n", mapa.calcularFatorCarga());  // Deve imprimir 0.80

        // Testa remoção
        mapa.remover(6);
        System.out.println("Buscar chave 6 após remover: " + mapa.buscar(6));  // Deve imprimir null

        // Novo fator de carga após remoção
        System.out.printf("Fator de carga após remover: %.2f%n", mapa.calcularFatorCarga());  // Deve imprimir 0.60
    }
}