package e1;

public abstract class CuentasBancarias {
  private String IBAN;
  private long saldo;
     public CuentasBancarias(String IBAN,long saldo){
         this.IBAN=IBAN;
         this.saldo=saldo;
     }





    public String getIBAN() {
        return IBAN;
    }
    public void setIBAN(String IBAN){this.IBAN=IBAN;}



    public long getSaldo() {
        return saldo;
    }
    public void setSaldo(long saldo){this.saldo=saldo;}

    public void IngresarDinero(long dinero){
         //una cuenta normal puede ingresar el dinero que quiera siempre que sea positivo
        if(dinero>0){
        saldo+=dinero;}
        else{
            throw new IllegalArgumentException("Debes ingresar dinero positivo");
        }

    }


    public void RetirarDinero(long dinero,Clientes clientes){
        //una cuenta normal puede retirar dinero siempre y cuando no retire mas de lo que tiene
         clientes.RetirarDinero(dinero);
    }
}


