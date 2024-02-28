package e2;
import java.util.Arrays;
import java.util.List;

public class Batalla extends NodoCompuesto{
    private String type;
    private String number;
    private int enemyHP;
    private int enemyBlindaje;
    private int enemyPoderFuego;
    private Nodo leftNodo;
    private Nodo rightNodo;
    private List<Nodo> hijo;
    public Batalla(String number,String type,int enemyHP,int enemyBlindaje,int enemyPoderFuego,Nodo leftNodo,Nodo rightNodo){
        this.enemyHP=enemyHP;
        this.enemyBlindaje=enemyBlindaje;
        this.enemyPoderFuego=enemyPoderFuego;
        this.leftNodo=leftNodo;
        this.rightNodo=rightNodo;
        this.type=type;
        this.number=number;
        this.hijo=Arrays.asList(leftNodo,rightNodo);
    }
    @Override
    public Nodo getNextNodo(Flota flota){
        int damage=enemyPoderFuego-flota.getBlindaje();
        if(damage>0){
        flota.RecibirDamage(damage);}
        int damageEnemy=flota.getPoderFuego()-enemyBlindaje;

        if((enemyHP-damageEnemy)<=0){
            return leftNodo;
        }else{
            return rightNodo;
        }

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
