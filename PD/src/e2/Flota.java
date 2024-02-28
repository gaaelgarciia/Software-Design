package e2;

public class Flota {
    private int HP;
    private int Blindaje;
    private int PoderFuego;
    private int Antiaereo;
    private int LineaVision;
    private String lastVisitedNode;
    private String lastBeforeNodofin;
    public Flota(int HP,int Blindaje,int PoderFuego,int Antiaereo,int LineaVision){
        this.HP=HP;
        this.Blindaje=Blindaje;
        this.PoderFuego=PoderFuego;
        this.Antiaereo=Antiaereo;
        this.LineaVision=LineaVision;
        this.lastVisitedNode=null;
        this.lastBeforeNodofin=null;
    }
    public void RecibirDamage(int damage){
        this.HP-=damage;
    }
    public int getHP(){
        return HP;
    }

    public int getAntiaereo() {
        return Antiaereo;
    }

    public int getBlindaje() {
        return Blindaje;
    }

    public int getPoderFuego() {
        return PoderFuego;
    }

    public int getLineaVision() {
        return LineaVision;
    }
    public String getLastVisitedNode(){return lastVisitedNode;}
    public void setLastVisitedNode(String lastVisitedNode){
        this.lastVisitedNode=lastVisitedNode;
    }
    public String getLastBeforeNodofin(){return lastBeforeNodofin;}
    public void setLastBeforeNodofin(String lastBeforeNodofin){
        this.lastBeforeNodofin=lastBeforeNodofin;
    }
}
