package Lista05;

public class App {

    public static void main(String[] args) {

        PilhaVetor<Integer> pilhaV = new PilhaVetor<>(10);
        pilhaV.push(1);
        pilhaV.push(2);
        pilhaV.push(3); // Topo

        PilhaLista<Integer> pilhaL = new PilhaLista<>();
        pilhaL.push(10);
        pilhaL.push(20); // Topo

// Após a concatenação:
        pilhaL.concatenarComPilhaVetor(pilhaV);

        System.out.println(pilhaL.toString());

    }
}
