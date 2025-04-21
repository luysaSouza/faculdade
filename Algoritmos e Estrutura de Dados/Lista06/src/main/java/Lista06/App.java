package Lista06;

public class App {
    public static void main(String[] args) {
        System.out.println("------------ FILA VETOR ------------");
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);

        // inserir
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        // toString
        System.out.println(filaVetor); // 10,20,30

        // peek
        System.out.println("Primeiro: " + filaVetor.peek()); // 10

        // retirar
        System.out.println("Retirado: " + filaVetor.retirar()); // 10

        // estaVazia
        System.out.println("Está vazia? " + filaVetor.estaVazia()); // false

        // contarOcorrencias
        filaVetor.inserir(20);
        System.out.println("Ocorrências de 20: " + filaVetor.contarOcorrencias(20)); // 2

        // inserirComPrioridade
        filaVetor.inserirComPrioridade(99);
        System.out.println("Com prioridade: " + filaVetor); // 99,20,30,20

        // inverter
        filaVetor.inverter();
        System.out.println("Invertida: " + filaVetor); // 20,30,20,99

        // posicaoDoElemento
        System.out.println("Posição do 30: " + filaVetor.posicaoDoElemento(30)); // 1

        // removerElemento
        filaVetor.removerElemento(20);
        System.out.println("Após remover 20: " + filaVetor); // 30,20,99

        // ehIgual
        FilaVetor<Integer> outra = new FilaVetor<>(5);
        outra.inserir(30);
        outra.inserir(20);
        outra.inserir(99);
        System.out.println("Filas iguais? " + filaVetor.ehIgual(outra)); // true

        // criarFilaConcatenada
        FilaVetor<Integer> filaVetor1 = new FilaVetor<>(3);
        FilaVetor<Integer> filaVetor2 = new FilaVetor<>(3);
        filaVetor1.inserir(1);
        filaVetor1.inserir(2);
        filaVetor2.inserir(3);
        filaVetor2.inserir(4);
        FilaVetor<Integer> f3 = filaVetor1.criarFilaConcatenada(filaVetor2);
        System.out.println("Fila concatenada: " + f3); // 1,2,3,4

        // liberar
        filaVetor.liberar();
        System.out.println("Fila liberada: " + filaVetor); // ""

        System.out.println("\n------------ FILA LISTA ------------");
        FilaLista<Integer> filaLista = new FilaLista<>();

        // inserir
        filaLista.inserir(10);
        filaLista.inserir(20);
        filaLista.inserir(30);

        // toString
        System.out.println(filaLista); // 10,20,30

        // peek
        System.out.println("Primeiro: " + filaLista.peek()); // 10

        // retirar
        System.out.println("Retirado: " + filaLista.retirar()); // 10

        // estaVazia
        System.out.println("Está vazia? " + filaLista.estaVazia()); // false

        // contarOcorrencias
        filaLista.inserir(20);
        System.out.println("Ocorrências de 20: " + filaLista.contarOcorrencias(20)); // 2

        // contem
        System.out.println("Contém 30? " + filaLista.contem(30)); // true

        // intercalarCom
        FilaLista<Integer> outraFila = new FilaLista<>();
        outraFila.inserir(100);
        outraFila.inserir(200);
        filaLista.intercalarCom(outraFila);
        System.out.println("Intercalada: " + filaLista); // 20,100,20,200,30

        // removerDuplicados
        filaLista.removerDuplicados();
        System.out.println("Sem duplicatas: " + filaLista); // 20,100,200,30

        // compararFilas
        FilaLista<Integer> filaLista1 = new FilaLista<>();
        FilaLista<Integer> filaLista2 = new FilaLista<>();
        filaLista1.inserir(1);
        filaLista1.inserir(2);
        filaLista2.inserir(1);
        filaLista2.inserir(2);
        System.out.println("Filas iguais? " + filaLista1.compararFilas(filaLista2)); // true

        // liberar
        filaLista.liberar();
        System.out.println("Fila após liberar: " + filaLista); // ""

    }
}
