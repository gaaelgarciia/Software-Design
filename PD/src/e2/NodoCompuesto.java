package e2;


import java.util.ArrayList;
import java.util.List;

public abstract class NodoCompuesto implements Nodo{
    private List<Nodo> NodoList=new ArrayList<>();
    private String lastVisitedNodo;
    private String lastbeforeNodofin;
    public void addNodo(Nodo nodo){
        NodoList.add(nodo);
    }


    @Override
    public void ejecutar(Flota flota){
        for(Nodo nodo:NodoList){
            Nodo nextNodo=nodo.getNextNodo(flota);
            if(flota.getHP()<=0){
                flota.setLastBeforeNodofin(nextNodo.getLetter());
            }else{
            flota.setLastVisitedNode(nextNodo.getLetter());}
            nextNodo.ejecutar(flota);
        }
        lastVisitedNodo=flota.getLastVisitedNode();
        lastbeforeNodofin=flota.getLastBeforeNodofin();
    }
    @Override
    public String getLastNodo(){
        if(lastbeforeNodofin!=null){
            return lastbeforeNodofin;
        }else{
        return lastVisitedNodo;}
    }
    @Override
    public abstract Nodo getNextNodo(Flota flota);
    @Override
    public abstract String getLetter();
    @Override
    public  abstract String getName();
    @Override
    public abstract List<Nodo> getChildren();
}
