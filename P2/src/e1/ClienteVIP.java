package e1;

public class ClienteVIP extends Clientes {
    public ClienteVIP(String DNI,CuentasBancarias cuentasBancarias){
        super(DNI,cuentasBancarias);

    }
    @Override
    public long MinimoIngreso(){
        return 0;
    }
    @Override
    public long MinimoRetirada(){
        return 0;
    }
    @Override
    public long ComisionRetirada(){
        return 0;
    }
    @Override
    public void IngresarDineroAPlazo(long dinero){
        //no tienen un limite minimo de ingreso
        getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()+dinero);
    }
    @Override
    public void RetirarDinero(long dinero){
        //pueden sacar dinero dejando la cuenta en saldo negativo
        getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()-dinero);
    }
    @Override
    public void RetirarDineroAPlazo(long dinero){
        //no se les aplica una comision por la retirada de dinero
        getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()-dinero);
    }

}
