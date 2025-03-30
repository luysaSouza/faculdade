package Lista05;

public class App {

    public static void main(String[] args) {

        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        pilha.liberar();
        
        pilha.push(10);
        
        System.out.println(pilha.toString());
    }
}
