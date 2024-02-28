package e1;

public abstract class  Clientes {
    private String DNI;
    private CuentasBancarias cuentasBancarias;
    public Clientes(String DNI, CuentasBancarias cuentasBancarias){
        this.DNI=DNI;
        this.cuentasBancarias=cuentasBancarias;
    }
    public String getDNI(){
        return DNI;
    }
    public CuentasBancarias getCuentasBancarias(){
        return cuentasBancarias;
    }

//las cantidades monetarias estan en centimos
    public long MinimoIngreso(){
        return 100000;
    }
    public long ComisionRetirada(){
        return 4;
    }
    public long MinimoRetirada(){
        return 300;
    }

    public void IngresarDineroAPlazo(long dinero){
        //solo puede ingresar dinero si supera los 1000 euros
        if(dinero>=MinimoIngreso()){
            cuentasBancarias.setSaldo(cuentasBancarias.getSaldo()+dinero);
        }else{
            throw new IllegalArgumentException("Debes ingresar un minimo de 1000 euros");
        }
    }
    public void RetirarDinero(long dinero){
        if(dinero<=cuentasBancarias.getSaldo()){
            cuentasBancarias.setSaldo((cuentasBancarias.getSaldo())-dinero);
        }else{
            throw new IllegalArgumentException("No puedes retirar mas de lo que tienes en el banco");
        }
    }
    public void RetirarDineroAPlazo(long dinero){
        //no puede retirar mas de lo que tiene
        if ( dinero <= cuentasBancarias.getSaldo()) {
            if((dinero*ComisionRetirada())/100<MinimoRetirada()){
                //si la comision es inferior a 3 euros se le aplica la comision minima de 3 euros
                cuentasBancarias.setSaldo(cuentasBancarias.getSaldo()-(dinero+MinimoRetirada()));
            }else{
                //sino se le aplica una comision del 4%
                cuentasBancarias.setSaldo(cuentasBancarias.getSaldo()-(dinero + (dinero * ComisionRetirada()) / 100));}
        } else {
            throw new IllegalArgumentException("No puedes retiras mas de lo que tienes");
        }
    }

}
