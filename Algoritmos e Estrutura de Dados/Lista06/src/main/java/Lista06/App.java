package Lista06;

public class App {
    public static void main(String[] args) {
        FilaVetor<Integer> f = new FilaVetor<>(8);

        f.inserir(0);
        f.inserir(0);
        f.inserir(3);
        f.inserir(1);
        f.inserir(5);
        f.inserir(5);

        f.inserir(5);

        f.retirar();
        f.retirar();

        System.out.printf(f.toString() + "\n");

        FilaVetor<Integer> f2 = new FilaVetor<>(10);

        f2.inserir(30);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);
        f2.inserir(40);

        FilaVetor<Integer> f3 = f.criarFilaConcatenada(f2);

        System.out.printf(f3.toString());
    }
}
