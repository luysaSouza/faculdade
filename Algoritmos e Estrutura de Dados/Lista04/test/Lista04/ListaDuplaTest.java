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
                
        
    }
}
