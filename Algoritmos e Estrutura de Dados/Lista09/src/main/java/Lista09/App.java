package Lista09;

import java.time.LocalDate;

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

        // Criando o mapa de dispersão com 10 posições
        MapaDispersao<Aluno> mapa2 = new MapaDispersao<>(10);

        // Criando objetos da classe Aluno
        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18)); // colisão com 12000
        Aluno a4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25)); // colisão com 14000

        // Inserindo alunos no mapa
        mapa2.inserir(a1.getMatricula(), a1);
        mapa2.inserir(a2.getMatricula(), a2);
        mapa2.inserir(a3.getMatricula(), a3);
        mapa2.inserir(a4.getMatricula(), a4);

        // Exibindo o mapa completo
        System.out.println(">>> Mapa de Dispersão:");
        mapa2.exibirMapa();

        // Verificando se chaves existem
        System.out.println("\n>>> Verificação de chaves:");
        System.out.println("Contém chave 12000? " + mapa2.contemChave(12000));
        System.out.println("Contém chave 99999? " + mapa2.contemChave(99999));

        // Quantidade total de elementos
        System.out.println("\n>>> Quantidade total de elementos:");
        System.out.println("Quantidade: " + mapa2.quantidadeElementos());

        // Contagem de colisões
        System.out.println("\n>>> Contagem de colisões:");
        System.out.println("Colisões: " + mapa2.contarColisoes());

        // Maior lista (índice com mais colisões)
        System.out.println("\n>>> Tamanho máximo de lista:");
        System.out.println("Tamanho máximo: " + mapa2.tamanhoMaximoLista());

        // Fator de carga
        System.out.println("\n>>> Fator de carga:");
        System.out.println("Fator de carga: " + mapa2.calcularFatorCarga());

        System.out.println("\n>>> Quantidade de listas não vazias:");
        System.out.println("Listas não vazias: " + mapa2.quantidadeListasNaoVazias());

        System.out.println("\n>>> Verificar se o mapa está vazio:");
        System.out.println("Está vazio? " + mapa2.estaVazio());

        System.out.println("\n>>> Carga média por lista:");
        System.out.println("Carga média: " + mapa2.cargaMediaPorLista());

        System.out.println("\n>>> Substituir um aluno:");
        Aluno novoA1 = new Aluno(12000, "Jean Atualizado", LocalDate.of(2000, 1, 1));
        Aluno anterior = mapa2.substituir(12000, novoA1);
        System.out.println("Anterior: " + anterior);
        System.out.println("Novo: " + mapa2.buscar(12000));

        System.out.println("\n>>> Limpar o mapa:");
        mapa2.limpar();
        mapa2.exibirMapa();
        System.out.println("Está vazio agora? " + mapa2.estaVazio());

        //-----------------------------------------
        MapaDispersao<String> mapa3 = new MapaDispersao<>(10);
        MapaDispersao<String> mapa4 = new MapaDispersao<>(10);

        mapa3.inserir(1, "João");
        mapa3.inserir(2, "Maria");

        mapa4.inserir(3, "Pedro");
        mapa4.inserir(4, "Ana");

        System.out.println("Mapa 1 antes de incluir:");
        mapa3.exibirMapa();

        System.out.println("\nMapa 2:");
        mapa4.exibirMapa();

        // Incluir todos os elementos do mapa2 em mapa1
        mapa3.incluirTodos(mapa4);

        System.out.println("\nMapa 1 depois de incluirTodos:");
        mapa3.exibirMapa();
    }
}