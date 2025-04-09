package Lista06;

public class App {
    public static void main(String[] args) {
        FilaLista<Integer> f = new FilaLista<>();

        f.inserir(10);
        f.inserir(20);
        f.inserir(30);
        f.inserir(40);
        f.inserir(50);
        f.inserir(60);
        System.out.println(f.retirar());

        System.out.println(f.toString());
    }
}
