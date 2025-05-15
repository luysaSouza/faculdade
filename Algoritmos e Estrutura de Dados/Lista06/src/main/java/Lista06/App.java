package Lista06;

public class App {
    public static void main(String[] args) {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(10);

        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);
        filaVetor.retirar();
        filaVetor.inserir(40);

        filaVetor.encolher();
        System.out.println(filaVetor.toString());
        System.out.println(filaVetor.getInicio());
        filaVetor.encolher();
        System.out.println(filaVetor.toString());

    }
}
