package e2;

public class FireBallSpell extends Object  implements AttackObject{
    private int damage;
    private int minimumMana;
    private int usage;


    public FireBallSpell(String codename, int damage, int minimumMana, int usage){
        super(codename);
        this.damage = damage;
        this.minimumMana = minimumMana;
        this.usage = usage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }


    @Override
    public int getDamage() {
        if(usage == 1){
            usage--;
            return damage-1;
        }
        else{
            usage--;
            return damage;
        }
    }

    @Override
    public int getMinimumMana() {
        return minimumMana;
    }

    @Override
    public int getUsage() {
        return usage;
    }

}
