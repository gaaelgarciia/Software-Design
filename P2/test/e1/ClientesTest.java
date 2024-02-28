package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientesTest {
    private static Clientes a;
    private static CuentasBancarias b;
    @BeforeAll
    static void setUp(){

        b=new CuentaCorriente("123456789",100000);
        a=new ClienteNormal("34567896J",b);

    }

    @Test
    void getDNI() {
        assertEquals(a.getDNI(),"34567896J");
    }

    @Test
    void getCuentasBancarias() {
        assertEquals(a.getCuentasBancarias(),b);
    }

    @Test
    void minimoIngreso() {
        assertEquals(a.MinimoIngreso(),100000);
    }

    @Test
    void comisionRetirada() {
        assertEquals(a.ComisionRetirada(),4);
    }

    @Test
    void minimoRetirada() {
        assertEquals(a.MinimoRetirada(),300);
    }
}