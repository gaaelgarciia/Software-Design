package e2;

public class Sword extends Object implements AttackObject, ProtectionObject{

    private int damage;
    private int minimumMana;
    private int usage;
    private int  protection;
    private int minimumForce;
    private void AttackProperties(int damage, int minimumMana, int usage){
        this.minimumMana = minimumMana;
        this.damage = damage;
        this.usage = usage;
    }
    private void ProtectionProperties(int protection, int minimumForce){
        this.minimumForce= minimumForce;
        this.protection = protection;
    }

    public Sword(String codename, int damage, int protection, int minimumMana, int usage,
                 int minimumForce){ //aqui tengo que hacer que pase como atributos por separado los de ataque y los de defensa
        super(codename);
        this.AttackProperties(damage,minimumMana,usage);
        this.ProtectionProperties(protection, minimumForce);
    }
    public AttackObject setAttackObject(){
        Sword attackSword = new Sword(getCodename(),getDamage(),0,getMinimumMana(),getUsage(),0);
        return attackSword;
    }
    public ProtectionObject setProtectionObject(){
        Sword protectionSword = new Sword(getCodename(),0,getprotection(),0,0,getminimumForce());
        return protectionSword;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
    @Override
    public int getDamage() {
        usage--;
        return damage;
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
