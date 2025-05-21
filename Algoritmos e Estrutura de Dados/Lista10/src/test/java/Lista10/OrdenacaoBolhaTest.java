package Lista10;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrdenacaoBolhaTest {

    @Test
    public void test01_ValidarOrdenacaoBolha() {
        Integer[] dados = {70,2,88,15,90,30};

        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();

        ordenacao.setInfo(dados);
        ordenacao.ordenar();

        Integer[] esperado = {2,15,30,70,88,90};

        assertEquals(ordenacao.getInfo(), esperado);
    }

    @Test
    public void test02_ValidarOrdenacaoBolhaOtimizado() {
        Integer[] dados = {70,2,88,15,90,30};

        OrdenacaoBolhaOtimizada<Integer> ordenacao = new OrdenacaoBolhaOtimizada<>();

        ordenacao.setInfo(dados);
        ordenacao.ordenar();

        Integer[] esperado = {2,15,30,70,88,90};

        assertEquals(ordenacao.getInfo(), esperado);
    }

    @Test
    public void test03_ValidarOrdenacaoQuicksort() {
        Integer[] dados = {70,2,88,15,90,30};

        OrdenacaoQuickSort<Integer> ordenacao = new OrdenacaoQuickSort<>();

        ordenacao.setInfo(dados);
        ordenacao.ordenar();

        Integer[] esperado = {2,15,30,70,88,90};

        assertEquals(ordenacao.getInfo(), esperado);
    }
}