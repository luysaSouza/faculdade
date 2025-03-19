package Lista03;

import Lista03.ListaEncadeada;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListaEncadeadaTest {

    @Test
    public void test01_ReconhecerListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        assertTrue(lista.estaVazia());
    }

    @Test
    public void test02_ReconhecerListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        assertFalse(lista.estaVazia());
    }

    @Test
    public void test03_InclusaoDeUmNumero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        assertEquals(5, lista.getPrimeiro().getInfo(), 0);
        assertEquals(1, lista.obterComprimento());
        // OU
        assertEquals(null, lista.getPrimeiro().getProximo());
    }

    @Test
    public void test04_InclusaoDeTresNumeros() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        assertEquals(15, lista.getPrimeiro().getInfo(), 0);
        assertEquals(10, lista.getPrimeiro().getProximo().getInfo(), 0);
        assertEquals(5, lista.getPrimeiro().getProximo().getProximo().getInfo(), 0);

        assertEquals(3, lista.obterComprimento());
    }

    @Test
    public void test05_BuscaDeDadosNaListaNaPrimeiraPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(lista.getPrimeiro(), lista.buscar(20));
    }

    @Test
    public void test06_BuscaDeDadosNoMeioDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(15, lista.buscar(15).getInfo(), 0);
    }

    @Test
    public void test07_BuscaDeDadoInexistente() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(null, lista.buscar(50));
    }

    @Test
    public void test08_ExclusaoDePrimeiroElementoDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void test09_ExclusaoDeElementoNoMeioDaLista() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(15);

        assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void test10_RetornaNoDaPosicaoZero() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterNo(0).getInfo(), 0);
    }

    @Test
    public void test11_RetornaNoDaUltimaPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(5, lista.obterNo(3).getInfo(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12_RecusaTentativaDePosicaoDeNoInvalida() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.obterNo(10);
    }

    @Test
    public void test13_ObterComprimentoDeListaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void test14_ObterComprimentoDeListaNaoVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}
