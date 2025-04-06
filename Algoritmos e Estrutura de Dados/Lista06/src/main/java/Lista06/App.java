package Lista06;

public class App {
    public static void main(String[] args) {
        FilaVetor<Integer> f = new FilaVetor<>(5);

        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.inserir(40);
        System.out.println(f.retirar());
        System.out.println(f.retirar());
        System.out.println(f.toString());

    }
}
