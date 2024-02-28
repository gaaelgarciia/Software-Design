package e1;

public class CuentaCorriente extends CuentasBancarias {
    //una cuenta corriente actua igual que una cuenta normal
    public CuentaCorriente(String IBAN,long saldo){
        super(IBAN,saldo);
    }

}
