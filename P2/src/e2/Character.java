package e2;

import java.util.ArrayList;

public abstract class Character{

   private int live;
   private int power;
   private int mana;
   private String id;
    private ArrayList<AttackObject> attackObjects;
    private ArrayList<ProtectionObject> protectionObjects;
    public Character(int live, int power, int mana, String id, ArrayList<AttackObject> AttackObject, ArrayList<ProtectionObject> ProtectionObject){
        this.live = Math.min(20,Math.max(0,live));
        this.power = Math.min(10,Math.max(1,power));
        this.mana = Math.min(10,Math.max(0,mana));
        this.id = id;
        this.attackObjects = AttackObject;
        this.protectionObjects = ProtectionObject;
    }
    public void setLive(int live){this.live = Math.max(live, 0);}
    public int getLive(){return live;}
    public int getPower(){return power;}
    public int getMana(){return mana;}
    public boolean alive(){return live != 0;}
    public void addAttackObject(AttackObject object){
        attackObjects.add(object);
    }
    public void addProtectionObject(ProtectionObject object){
        protectionObjects.add(object);
    }
    public void deleteAttackObject(AttackObject object){
        attackObjects.remove(object);
    }
    public void deleteProtectionObject(ProtectionObject object){
        protectionObjects.remove(object);
    }

    private int TotalProtection(){
        int total = 0;
        for(ProtectionObject protectionObject : protectionObjects)
            if(protectionObject.getminimumForce() > getPower())
                continue;
            else
                total += protectionObject.getprotection();
        return total;
    }
    private int TotalDamage(){
        int damage = 0;
        for(AttackObject attackObject : attackObjects) {
            if (attackObject.getUsage() == 0) {
                deleteAttackObject(attackObject);
                continue;
            }
            else if(getMana() < attackObject.getMinimumMana())
                continue;
            else
                damage = attackObject.getDamage();
                break;

        }
        return damage;
    }

    public void attack(Character character){
        int EnemyProtection = character.TotalProtection();
        int ActualDamage = TotalDamage();
        int EfectiveDamage = ActualDamage - EnemyProtection;
        if(EfectiveDamage < 0)
            EfectiveDamage = 0;
        character.setLive(character.getLive() - EfectiveDamage);
    }
}
