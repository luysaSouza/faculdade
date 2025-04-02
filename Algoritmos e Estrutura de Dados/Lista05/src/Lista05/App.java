package Lista05;

public class App {

    public static void main(String[] args) {

        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(2);

        pilha2.push(40);
        pilha2.push(50);

        pilha.concatenar(pilha2);
        
        System.out.println(pilha.toString());
    }
}
