package Lista06;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilaListaTest {

    @Test
    public void test01_ReconheceFilaVazia() {
        FilaLista<Integer> fila = new FilaLista<>();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void test02_ReconheceFilaNaoVazia() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void test03_DadosEnfileiradosEDesenfileradosCorretamente() {
        FilaLista<Integer> fila = new FilaLista<>();
    
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar(), 0);
        assertEquals(20, fila.retirar(), 0);
        assertEquals(30, fila.retirar(), 0);
        assertTrue(fila.estaVazia());
    }

    @Test
    public void test04_MetodoPeekRetornaInicioDaFila() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek(), 0);
        assertEquals(10, fila.retirar(), 0);
    }

    @Test
    public void test05_MetodoLiberarRemoveElementosDaFila() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();

        assertTrue(fila.estaVazia());
    }
}