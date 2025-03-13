package Lista02;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListaEstaticaTest {
    
    @Test
    public void test01_IncluirDadosNaLista() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals("5,10,15,20", lista.toString());
    }
    
    @Test
    public void test02_ObterTamanhoDaLista() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(4, lista.getTamanho());
    }
    
    @Test
    public void test03_BuscarComElementoExistente() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(2, lista.buscar(15));
    }
    
    @Test
    public void test04_BuscarComElementoInexistente() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(-1, lista.buscar(30));
    }
    
    @Test
    public void test05_MetodoRetirar() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        
        assertEquals("5,15,20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }
    
    @Test
    public void test06_InclusaoQueProvocaRedimensionamento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);
        lista.inserir(10);
        lista.inserir(11);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(14);
        lista.inserir(15);
        
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
        assertEquals(15, lista.getTamanho());
    }
    
    @Test
    public void test07_MetodoObterElemento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(20, (int)lista.obterElemento(3));
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void test08_LancamentoDeExecaoNoMetodoObterElemento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.obterElemento(5);
    }
    
    @Test
    public void test09_VerificarSeMetodoLiberarRemoveTodosOsElementos() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        
        assertTrue(lista.estaVazia());
    }
    
    @Test
    public void test10_MetodoInvesterComQuantidadeDeDadosPares() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inverter();
        
        assertEquals("20,15,10,5", lista.toString());
    }
    
    @Test
    public void test11_MetodoInvesterComQuantidadeDeDadosImpares() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inverter();
        
        assertEquals("25,20,15,10,5", lista.toString());
    }
}
