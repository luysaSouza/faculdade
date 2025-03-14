package Lista04;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListaDuplaTest {

    @Test
    public void test01_InlcusaoDeDados() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        int valor = lista.getPrimeiro().getInfo();

        while (p.getProximo() != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getProximo().getInfo();
            }
            p = p.getProximo();
        }

        while (p != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getAnterior().getInfo();
            }
            p = p.getAnterior();
        }
    }

    @Test
    public void test02_BuscarElementoNoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.buscar(20).getInfo(), 0);
    }

    @Test
    public void test03_BuscarElementoNoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(10, lista.buscar(10).getInfo(), 0);
    }

    @Test
    public void test04_RemoverElementoDoInicio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(20);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        int valor = lista.getPrimeiro().getInfo();

        while (p.getProximo() != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getProximo().getInfo();
            }
            p = p.getProximo();
        }

        while (p != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getAnterior().getInfo();
            }
            p = p.getAnterior();
        }
    }

    @Test
    public void test05_RemoverElementoDoMeio() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        int valor = lista.getPrimeiro().getInfo();

        while (p.getProximo() != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getProximo().getInfo();
            }
            p = p.getProximo();
        }

        while (p != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getAnterior().getInfo();
            }
            p = p.getAnterior();
        }
    }

    @Test
    public void test06_RemoverElementoDoFinal() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(5);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        int valor = lista.getPrimeiro().getInfo();

        while (p.getProximo() != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getProximo().getInfo();
            }
            p = p.getProximo();
        }

        while (p != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getAnterior().getInfo();
            }
            p = p.getAnterior();
        }
    }

    @Test
    public void test07_LiberarDadosDaLista() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoListaDupla<Integer> p = lista.getPrimeiro();
        int valor = lista.getPrimeiro().getInfo();

        while (p.getProximo() != null) {
            assertEquals(valor, p.getInfo(), 0);
            if (p.getAnterior() == null) {
                break;
            } else {
                valor = p.getProximo().getInfo();
            }
            p = p.getProximo();
        }
        
        lista.liberar();
        
        while (p.getProximo() != null) {
            assertNull(p.getAnterior());
            assertNull(p.getProximo());
            p = p.getProximo();
        }
    }
}
