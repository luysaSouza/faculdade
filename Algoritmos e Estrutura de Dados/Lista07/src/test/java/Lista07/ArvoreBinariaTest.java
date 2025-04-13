package Lista07;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaTest {

    @Test
    public void test01_ReconheceArvoreVazia(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        assertTrue(arvore.estaVazia());
    }

    @Test
    public void test02_ReconheceArvoreNaoVazia(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        arvore.setRaiz(n1);

        assertFalse(arvore.estaVazia());
    }

    @Test
    public void test03_RepresentacaoTextualPreOrdem(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);

        arvore.setRaiz(n1);
        n1.setEsquerda(n2);
        n1.setDireita(n3);
        n2.setDireita(n4);
        n3.setEsquerda(n5);
        n3.setDireita(n6);

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvore.toString());
    }

    @Test
    public void test04_ValorArmazenadoNoRaizPertenceArvore(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1, n2, n3);

        arvore.setRaiz(n1);

        assertTrue(arvore.pertence(1));
    }

    @Test
    public void test05_ValorArmazenadoEmNoNaoRaizENoNaoFolhaPertenceArvore(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1, n2, n3);

        arvore.setRaiz(n1);

        assertTrue(arvore.pertence(3));
    }

    @Test
    public void test06_ValorArmazenadoNoFolhaPertenceArvore(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1, n2, n3);

        arvore.setRaiz(n1);

        assertTrue(arvore.pertence(6));
    }

    @Test
    public void test07_ValorArmazenadoNaoPertenceArvore(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1, n2, n3);

        arvore.setRaiz(n1);

        assertFalse(arvore.pertence(10));
    }

    @Test
    public void test08_ContarQuantidadeDeNosComArvoreDeAltura2(){
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> n4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> n5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> n6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> n3 = new NoArvoreBinaria<>(3, n5, n6);
        NoArvoreBinaria<Integer> n2 = new NoArvoreBinaria<>(2, null, n4);
        NoArvoreBinaria<Integer> n1 = new NoArvoreBinaria<>(1, n2, n3);

        arvore.setRaiz(n1);

        assertEquals(6, arvore.contarNos());
    }
}