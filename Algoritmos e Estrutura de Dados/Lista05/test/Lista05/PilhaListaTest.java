package Lista05;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilhaListaTest {

    @Test
    public void test01_MetodoReconhecePilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        assertTrue(pilha.estaVazia());
    }

    @Test
    public void test02_MetodoReconhecePilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);

        assertFalse(pilha.estaVazia());
    }

    @Test
    public void test03_DadosSaoEmpilhadosEDesempilhadosCorretamente() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop(), 0);
        assertEquals(20, pilha.pop(), 0);
        assertEquals(10, pilha.pop(), 0);
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void test04_MetodoPeekRetornaTopoDaPilha() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek(), 0);
        assertEquals(30, pilha.pop(), 0);
    }
    
    @Test
    public void test05_MetodoLiberarRemoveTodosOsElementos() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        
        assertTrue(pilha.estaVazia());
    }
}
