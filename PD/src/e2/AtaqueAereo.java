package e2;

import java.util.ArrayList;
import java.util.List;

public class AtaqueAereo extends NodoCompuesto {
    private String type;
    private String number;

    private int enemyDamage;
    private Nodo nodo;
    private List<Nodo> hijo=new ArrayList<>();
    public AtaqueAereo(String number,String type,int enemyDamage,Nodo nodo){
        this.enemyDamage=enemyDamage;
        this.nodo=nodo;
        this.number=number;
        this.type=type;
        hijo.add(nodo);
    }
    @Override
    public Nodo getNextNodo(Flota flota){
        int damage=enemyDamage-(2*flota.getAntiaereo()+ flota.getBlindaje());
        flota.RecibirDamage(damage);

        return nodo;
    }
    @Override
    public String getLetter(){
        return number;
    }
    @Override
    public String getName(){return type;}
    @Override
    public List<Nodo> getChildren(){return hijo;}
}
