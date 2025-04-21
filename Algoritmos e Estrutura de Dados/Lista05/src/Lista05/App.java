package Lista05;

public class App {
    public static void main(String[] args) {
        System.out.println("------------ PILHA VETOR ------------");
        PilhaVetor<Integer> pilhaVetor = new PilhaVetor<>(10);

        // Métodos com retorno void
        pilhaVetor.push(10);   // Adiciona 10 à pilha
        pilhaVetor.push(20);   // Adiciona 20 à pilha
        pilhaVetor.push(30);   // Adiciona 30 à pilha
        pilhaVetor.push(40);   // Adiciona 40 à pilha
        pilhaVetor.push(50);   // Adiciona 50 à pilha

        System.out.println("PilhaVetor (toString): " + pilhaVetor.toString()); // Exibe pilha: 50,40,30,20,10

        // Métodos com retorno T
        Integer topo = pilhaVetor.peek();   // Retorna o topo da pilha (50)
        System.out.println("Topo da PilhaVetor (peek): " + topo);

        Integer desempilhado = pilhaVetor.pop();   // Retorna e remove o topo da pilha (50)
        System.out.println("Elemento desempilhado (pop): " + desempilhado);

        Integer minimo = pilhaVetor.minimo();  // Retorna o valor mínimo na pilha (10)
        System.out.println("Valor mínimo (minimo): " + minimo);

        // Métodos com retorno boolean
        boolean estaVazia = pilhaVetor.estaVazia();  // Retorna se a pilha está vazia (false)
        System.out.println("Está vazia (estaVazia): " + estaVazia);

        // Métodos com retorno int
        int ocorrencias = pilhaVetor.contarOcorrencias(20);  // Conta as ocorrências de 20 na pilha (1)
        System.out.println("Ocorrências de 20: " + ocorrencias);

        // Concatenar pilha
        PilhaVetor<Integer> outraPilhaVetor = new PilhaVetor<>(5);
        outraPilhaVetor.push(60);
        outraPilhaVetor.push(70);
        pilhaVetor.concatenar(outraPilhaVetor);
        System.out.println("PilhaVetor após concatenação: " + pilhaVetor.toString()); // Espera-se 50,40,30,20,10,70,60

        // Inverter pilha
        PilhaVetor<Integer> pilhaInvertida = pilhaVetor.invertida();
        System.out.println("PilhaVetor invertida: " + pilhaInvertida.toString());

        // Remover elementos
        pilhaVetor.remover(30);  // Remove o valor 30
        System.out.println("PilhaVetor após remoção do 30: " + pilhaVetor.toString());

        System.out.println("\n------------ PILHA LISTA ------------");
        PilhaLista<Integer> pilhaLista = new PilhaLista<>();

        // Métodos com retorno void
        pilhaLista.push(100);   // Adiciona 100 à pilha
        pilhaLista.push(200);   // Adiciona 200 à pilha
        pilhaLista.push(300);   // Adiciona 300 à pilha

        System.out.println("PilhaLista (toString): " + pilhaLista.toString());  // Exibe pilha: 300,200,100

        // Métodos com retorno T
        Integer topoLista = pilhaLista.peek();   // Retorna o topo da pilha (300)
        System.out.println("Topo da PilhaLista (peek): " + topoLista);

        Integer desempilhadoLista = pilhaLista.pop();   // Retorna e remove o topo da pilha (300)
        System.out.println("Elemento desempilhado da PilhaLista (pop): " + desempilhadoLista);

        // Métodos com retorno boolean
        boolean estaVaziaLista = pilhaLista.estaVazia();  // Retorna se a pilha está vazia (false)
        System.out.println("Está vazia (estaVazia) na PilhaLista: " + estaVaziaLista);

        // Concatenar PilhaVetor com PilhaLista
        pilhaLista.concatenarComPilhaVetor(outraPilhaVetor);
        System.out.println("PilhaLista após concatenar com PilhaVetor: " + pilhaLista.toString());

        // Inverter PilhaLista
        PilhaLista<Integer> pilhaListaInvertida = pilhaLista.inverter();
        System.out.println("PilhaLista invertida: " + pilhaListaInvertida.toString());

        // Buscar na pilha
        boolean encontrou = pilhaLista.buscar(100);  // Busca se o valor 100 está na pilha (true)
        System.out.println("Valor 100 encontrado (buscar): " + encontrou);
    }
}
