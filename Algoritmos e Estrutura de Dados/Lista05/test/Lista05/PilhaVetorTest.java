package Lista05;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilhaVetorTest {

    @Test
    public void test01_MetodoReconhecePilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        assertTrue(pilha.estaVazia());
    }

    @Test
    public void test02_MetodoReconheceNaoPilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);

        assertFalse(pilha.estaVazia());
    }

    @Test
    public void test03_DadosSaoEmpilhadosEDesempilhadosCorretamente() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop(), 0);
        assertEquals(20, pilha.pop(), 0);
        assertEquals(10, pilha.pop(), 0);
        assertTrue(pilha.estaVazia());
    }

    @Test (expected = PilhaCheiaException.class)
    public void test04_ExcecaoPilhaCheiaExceptionELancadaAoExcederCapacidade() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
    }
    
    @Test (expected = PilhaVaziaException.class)
    public void test05_ExcecaoPilhaCheiaVaziaELancadaAoDesimpilharDadosDePilhaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);

        pilha.pop();
    }
    
    @Test
    public void test06_MetodoPeekRetornaTopoDaPilha() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        assertEquals(30, pilha.peek(), 0);
        assertEquals(30, pilha.pop(), 0);
    }
    
    @Test
    public void test07_MetodoLiberarRemoveTodosOsElementos() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        
        assertTrue(pilha.estaVazia());
    }
    
    @Test
    public void test08_ConferirConcatenacaoDePilhas() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);
        pilha2.push(40);
        pilha2.push(50);
        
        pilha.concatenar(pilha2);
        
        assertEquals("50,40,30,20,10", pilha.toString());
    }
}
