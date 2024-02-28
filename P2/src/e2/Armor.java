package e2;

public class Armor extends Object implements ProtectionObject{

    private int protection;
    private int minimumForce;
    public Armor(String codename, int protection, int minimumForce){
        super(codename);
        this.minimumForce = minimumForce;
        this.protection = protection;
    }


    @Override
    public int getprotection() {
        return protection;
    }

    @Override
    public int getminimumForce() {
        return minimumForce;
    }



}
