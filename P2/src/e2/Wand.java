package e2;

public class Wand extends Object implements AttackObject, ProtectionObject{
    private int damage;
    private int minimumMana;
    private int usage;
    private int protection;
    private int minimumForce;
    private boolean firstuse;
    private void AttackProperties(int damage, int minimumMana, int usage){
        this.minimumMana = minimumMana;
        this.damage = damage;
        this.usage = usage;
    }
    private void ProtectionProperties(int protection, int minimumForce){
        this.minimumForce= minimumForce;
        this.protection = protection;
    }

    public Wand(String codename, int damage, int minimumMana, int usage,
                int protection, int minimumForce){
        super(codename);
        this.AttackProperties(damage,minimumMana,usage);
        this.ProtectionProperties(protection, minimumForce);
        this.firstuse = true;
    }
    public AttackObject setAttackObject(){
        Wand attackWand = new Wand(getCodename(),getDamage(),getMinimumMana(),getUsage(),0,0);
        attackWand.firstuse = this.firstuse;
        return attackWand;
    }
    public ProtectionObject setProtectionObject(){
        Wand protectionWand = new Wand(getCodename(),0,0,0,getprotection(),getminimumForce());
        protectionWand.firstuse = this.firstuse;
        return protectionWand;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
    @Override
    public int getDamage() {
        if(firstuse){
            firstuse = false;
            usage--;
            return (damage * 2);
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


    @Override
    public int getprotection() {
        return protection;
    }

    @Override
    public int getminimumForce() {
        return minimumForce;
    }

}
