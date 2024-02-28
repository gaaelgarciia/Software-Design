package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaAPlazoTest {
    CuentaAPlazo cuenta1=new CuentaAPlazo("123456789",100000);
    Clientes cliente1=new ClienteNormal("34567898B",cuenta1);
    CuentaAPlazo cuenta2=new CuentaAPlazo("123423789",100000);
    Clientes cliente2=new ClientePreferente("34567898A",cuenta2);
    CuentaAPlazo cuenta3=new CuentaAPlazo("673456789",100000);
    Clientes cliente3=new ClienteVIP("34567398C",cuenta3);


    @Test
    void ingresarDinero() {
        //solo puedes introducir dinero superior a 1000 euros
        assertThrows(IllegalArgumentException.class,()->cuenta1.IngresarDinero(50000,cliente1));
        cuenta1.IngresarDinero(100000,cliente1);
        assertEquals(cuenta1.getSaldo(),200000);
        //solo puedes introducir dinero superior a 500 euros
        assertThrows(IllegalArgumentException.class,()->cuenta2.IngresarDinero(40000,cliente2));
        cuenta2.IngresarDinero(70000,cliente2);
        assertEquals(cuenta2.getSaldo(),170000);
        cuenta3.IngresarDinero(300,cliente3);
        assertEquals(cuenta3.getSaldo(),100300);
        cuenta3.IngresarDinero(100000,cliente3);
        assertEquals(cuenta3.getSaldo(),200300);
    }

    @Test
    void retirarDinero() {
        cuenta1.setSaldo(10000);
        //no puedes retirar mas de lo que tienes
        assertThrows(IllegalArgumentException.class,()->cuenta1.RetirarDinero(200100,cliente1));
        cuenta1.RetirarDinero(300,cliente1);
        assertEquals(cuenta1.getSaldo(),9400);
        cuenta1.RetirarDinero(8000,cliente1);
        assertEquals(cuenta1.getSaldo(),1080);
        cuenta2.setSaldo(20000);
        cuenta2.RetirarDinero(100,cliente2);
        assertEquals(cuenta2.getSaldo(),19800);
        cuenta2.RetirarDinero(10000,cliente2);
        assertEquals(cuenta2.getSaldo(),9600);
        cuenta3.setSaldo(1000);
        cuenta3.RetirarDinero(50,cliente3);
        assertEquals(cuenta3.getSaldo(),950);
        cuenta3.RetirarDinero(100000,cliente3);
        assertEquals(cuenta3.getSaldo(),-99050);
    }
}