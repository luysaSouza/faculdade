package Lista06;

public class App {
    public static void main(String[] args) {
        FilaVetor<Integer> f = new FilaVetor<>(2);

        f.inserir(1);
        f.inserir(2);
        f.inserir(3);
        f.inserir(4);
        f.inserir(5);
        f.inserir(6);
        f.inserir(7);
        f.inserir(8);

        System.out.println(f.toString());
    }
}
