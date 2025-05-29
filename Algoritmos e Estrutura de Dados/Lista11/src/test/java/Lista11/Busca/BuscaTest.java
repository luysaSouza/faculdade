package Lista11.Busca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuscaTest {

    @Test
    public void test01_LocalizarDadoAtravesDeBuscaLinear() {
        Integer[] lista = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        BuscaLinear<Integer> busca = new BuscaLinear<>();

        busca.setInfo(lista);

        assertEquals(2, busca.buscar(20));
    }

    @Test
    public void test02_LocalizarDadoAtravesDeBuscaLinearEmVetorOrdenado() {
        Integer[] lista = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        BuscaLinear<Integer> busca = new BuscaLinear<>();

        busca.setInfo(lista);

        assertEquals(4, busca.buscar(40));
    }

    @Test
    public void test03_LocalizarDadoAtravesDeBuscaBinaria() {
        Integer[] lista = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        BuscaLinear<Integer> busca = new BuscaLinear<>();

        busca.setInfo(lista);

        assertEquals(7, busca.buscar(70));
    }

    @Test
    public void test04_LocalizarDadoAtravesDeBuscaLinear() {
        Integer[] lista = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        BuscaLinear<Integer> busca = new BuscaLinear<>();

        busca.setInfo(lista);

        assertEquals(-1, busca.buscar(75));
    }
}