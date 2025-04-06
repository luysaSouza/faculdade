package Lista06;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilaVetorTest {

    @Test
    public void test01_ReconheceFilaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        assertTrue(fila.estaVazia());
    }

    @Test
    public void test02_ReconheceFilaNaoVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void test03_DadosEnfileiradosEDesenfileradosCorretamente() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar(), 0);
        assertEquals(20, fila.retirar(), 0);
        assertEquals(30, fila.retirar(), 0);
        assertTrue(fila.estaVazia());
    }

    @Test (expected = FilaCheiaException.class)
    public void test04_ExcecaoLancadaAoTentarExcederCapacidade() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
    }

    @Test (expected = FilaVaziaException.class)
    public void test05_ExcecaoLancadaAoTentarDesenfileirarDadosDeFilaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);

        fila.retirar();
    }

    @Test
    public void test06_MetodoPeekRetornaInicioDaFila() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek(), 0);
        assertEquals(10, fila.retirar(), 0);
    }

    @Test
    public void test07_MetodoLiberarRemoveElementosDaFila() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void test08_ConcatenacaoDeFilas() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        FilaVetor<Integer> fila2 = new FilaVetor<>(3);

        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> fila3 = fila.criarFilaConcatenada(fila2);

        assertEquals("10,20,30,40,50", fila3.toString());
        assertEquals("10,20,30", fila.toString());
        assertEquals("40,50", fila2.toString());
        assertEquals(8, fila3.getLimite());
    }
}