package e1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CuentasBancariasTest {
     CuentasBancarias cuenta1=new CuentaCorriente("123456789",100000);

     CuentasBancarias cuenta2=new CuentaCorriente("345678943",200000);
     CuentasBancarias cuenta3=new CuentaCorriente("1020304050",100000);
     Clientes cliente1=new ClienteNormal("35631432Q",cuenta1);
     Clientes cliente2=new ClientePreferente("32435674B",cuenta2);
     Clientes cliente3=new ClienteVIP("34578688A",cuenta3);
     private static CuentasBancarias a;

     @BeforeAll
     static void setUp(){

         a=new CuentaCorriente("123456789",100000);




     }

    @Test
    void getIBAN() {
         assertEquals(a.getIBAN(),"123456789");
    }



    @Test
    void getSaldo() {
         assertEquals(a.getSaldo(),100000);
    }

    @Test
    void ingresarDinero() {
        cuenta1.IngresarDinero(10000);
         assertEquals(cuenta1.getSaldo(),110000);
         //no podemos ingresar saldo negativo
         assertThrows(IllegalArgumentException.class,()-> cuenta1.IngresarDinero(-100));
    }

    @Test
    void retirarDinero() {
         cuenta1.setSaldo(110000);
         cuenta1.RetirarDinero(10000,cliente1);
         assertEquals(cuenta1.getSaldo(),100000);
         //no puedes retirar mas de lo que tienes
         assertThrows(IllegalArgumentException.class,()->cuenta1.RetirarDinero(200000,cliente1));

         cuenta2.RetirarDinero(250000,cliente2);
         assertEquals(cuenta2.getSaldo(),-50000);
         //puedes dejar la cuenta en negativo siempre que no sea superior a 1000 euros la deuda
         assertThrows(IllegalArgumentException.class,()->cuenta2.RetirarDinero(100000,cliente2));

         cuenta3.RetirarDinero(400000,cliente3);
         //puedes dejar la cuenta en negativo
         assertEquals(cuenta3.getSaldo(),-300000);

    }
}
