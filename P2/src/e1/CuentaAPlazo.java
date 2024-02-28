package e1;

public class CuentaAPlazo extends CuentasBancarias {
    public CuentaAPlazo(String IBAN,long saldo){
        super(IBAN,saldo);
    }
    public void IngresarDinero(long dinero,Clientes clientes) {
       clientes.IngresarDineroAPlazo(dinero);
    }


    public void RetirarDinero(long dinero,Clientes clientes) {

        clientes.RetirarDineroAPlazo(dinero);
    }
}
