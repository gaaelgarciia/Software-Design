package e2;

import java.util.Collections;
import java.util.List;

public class NodoFin implements Nodo{
    private String type;
    private String number;
    public NodoFin(String number,String type){
        this.number=number;
        this.type=type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }



    @Override
    public void ejecutar(Flota flota){

    }
    @Override
    public Nodo getNextNodo(Flota flota){return this;}
    @Override
    public String getLastNodo(){
        return this.getNumber();
    }
    @Override
    public String getLetter(){
        return number;
    }
    @Override
    public String getName(){return type;}
    @Override
    public List<Nodo> getChildren(){
        return Collections.emptyList();
    }

}
