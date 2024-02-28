package e1;

public class ClientePreferente extends Clientes{
    public ClientePreferente(String DNI,CuentasBancarias cuentasBancarias){
        super(DNI,cuentasBancarias);
    }
    @Override
    public long MinimoRetirada(){
        return 100;
    }
    @Override
    public long ComisionRetirada(){
        return 2;
    }
    @Override
    public long MinimoIngreso(){
        return 50000;
    }
    @Override
    public void IngresarDineroAPlazo(long dinero){
        //tiene que superar un limite minimo de 500 euros
        if(dinero>= MinimoIngreso()){
            getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()+dinero);
        }else{
            throw new IllegalArgumentException("Debes ingresar un minimo de 500 euros");
        }
    }
    @Override
    public void RetirarDinero(long dinero){
        //puede dejar la cuenta en saldo negativo siempre que no supere los 1000 euros
        if(dinero<=getCuentasBancarias().getSaldo()+100000){
            getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()-dinero);
        }else{
            throw new IllegalArgumentException("Has superado el saldo negativo de 1000 euros");
        }
    }
    @Override
    public void RetirarDineroAPlazo(long dinero){
        //si la comision no es superior o igual a 1 euro se le aplica la comision minima de 1 euro
        if((dinero*ComisionRetirada())/100<MinimoRetirada()){
            getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()-(dinero+MinimoRetirada()));
        }else{
            //sino se le aplica la comision del 2%
            getCuentasBancarias().setSaldo(getCuentasBancarias().getSaldo()-(dinero+(dinero*ComisionRetirada())/100));
        }
    }


}
