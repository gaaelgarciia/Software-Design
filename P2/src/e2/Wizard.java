package e2;

import java.util.ArrayList;

public class Wizard extends Character{
    public Wizard(String id, int live, int power, int mana, ArrayList<AttackObject> AttackObject, ArrayList<ProtectionObject> ProtectionObject){
        super(live, power, mana, id, AttackObject, ProtectionObject);
    }

}
