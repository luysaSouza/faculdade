package Lista05;

public class App {
    public static void main(String[] args) {
        
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        
        pilha.push(10);
        pilha.push(20);
        
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(10);
        
        pilha2.push(30);
        pilha2.push(40);
        
        System.out.println("Pilha 1: " + pilha.toString());
        System.out.println("Pilha 2: " + pilha2.toString());
        System.out.println();
        pilha2.concatenar(pilha);
        System.out.println("Pilha 1: " + pilha.toString());
        System.out.println("Pilha 2: " + pilha2.toString());
        System.out.println(pilha.peek());
    }
}
