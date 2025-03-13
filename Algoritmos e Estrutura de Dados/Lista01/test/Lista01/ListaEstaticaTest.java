package Lista01;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListaEstaticaTest {
    
    @Test
    public void test01_IncluirDadosNaLista() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals("5,10,15,20", lista.toString());
    }
    
    @Test
    public void test02_ObterTamanhoDaLista() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(4, lista.getTamanho());
    }
    
    @Test
    public void test03_BuscarComElementoExistente() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(2, lista.buscar(15));
    }
    
    @Test
    public void test04_BuscarComElementoInexistente() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(-1, lista.buscar(30));
    }
    
    @Test
    public void test05_MetodoRetirar() {
        ListaEstatica lista = new ListaEstatica();
        
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
        ListaEstatica lista = new ListaEstatica();
        
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
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(20, lista.obterElemento(3));
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void test08_LancamentoDeExecaoNoMetodoObterElemento() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.obterElemento(5);
    }
    
    @Test
    public void test09_VerificarSeMetodoLiberarRemoveTodosOsElementos() {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        
        assertTrue(lista.estaVazia());
    }
}
