package e2;
import java.util.Arrays;
import java.util.List;

public class Avistamiento extends NodoCompuesto{
    private String type;
    private String number;
    private int Distancia;
    private Nodo leftNodo;
    private Nodo rigthNodo;
    private List<Nodo> hijo;
    public Avistamiento(String number,String type,int Distancia,Nodo leftNodo,Nodo rigthNodo){
        this.Distancia=Distancia;
        this.leftNodo=leftNodo;
        this.rigthNodo=rigthNodo;
        this.type=type;
        this.number=number;
        this.hijo=Arrays.asList(leftNodo,rigthNodo);
    }
    @Override
    public Nodo getNextNodo(Flota flota){
        if(flota.getLineaVision()>=Distancia){
            return leftNodo;
        }else{
            return rigthNodo;
        }
    }
    @Override
    public String getLetter(){
        return number;
    }
    @Override
    public String getName(){return type;
    }
    @Override
    public List<Nodo> getChildren(){return hijo;}
}
