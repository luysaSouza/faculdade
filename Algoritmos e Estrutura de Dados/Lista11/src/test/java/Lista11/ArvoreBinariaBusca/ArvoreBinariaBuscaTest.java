package Lista11.ArvoreBinariaBusca;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTest {

    @Test
    public void test01_DadosArmazenadosAdequadamente() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);

        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", arvore.toString());
    }

    @Test
    public void test02_RemoverNoFolha() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);

        arvore.retirar(40);

        assertEquals("<50<30<25<><>><>><>>", arvore.toString());
    }

    @Test
    public void test03_RemoverNoComFilho() {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);

        arvore.retirar(71);

        assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>", arvore.toString());
    }
}