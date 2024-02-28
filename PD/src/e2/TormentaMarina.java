package e2;

import java.util.ArrayList;
import java.util.List;

public class TormentaMarina extends NodoCompuesto{
    private String type;
    private String number;
    private int Fuerza;
    private Nodo nodo;
    private List<Nodo>  hijo=new ArrayList<>();
    public TormentaMarina(String number,String type,int Fuerza,Nodo nodo){
        this.Fuerza=Fuerza;
        this.nodo=nodo;
        this.type=type;
        this.number=number;
        hijo.add(nodo);
    }
    @Override
    public Nodo getNextNodo(Flota flota){
        if(flota.getLineaVision()< Fuerza){
            flota.RecibirDamage(10);
        }

        return nodo;
    }
    @Override
    public String getLetter(){
        return number;
    }
    @Override
    public  String getName(){return type;}
    @Override
    public List<Nodo> getChildren(){return hijo ;}
}
