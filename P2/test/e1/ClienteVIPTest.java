package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteVIPTest {
    CuentasBancarias b=new CuentaCorriente("123456789",100000);
    ClienteVIP a=new ClienteVIP("12345678L",b);

    @Test
    void minimoIngreso() {
        assertEquals(a.MinimoIngreso(),0);
    }

    @Test
    void minimoRetirada() {
        assertEquals(a.MinimoRetirada(),0);
    }

    @Test
    void comisionRetirada() {
        assertEquals(a.ComisionRetirada(),0);
    }
}