package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    AttackObject FireBallSpell1 = new FireBallSpell("123",10, 1,5);
    AttackObject FireBallSpell2 = new FireBallSpell("123", 10, 1,5);
    AttackObject FireBallSpell3 = new FireBallSpell("123", 10, 1,5);
    AttackObject FireBallSpell4 = new FireBallSpell("123",10, 1,5);
    AttackObject FireBallSpell5=new FireBallSpell("123",10,5,1);

    ProtectionObject Armor1 = new Armor("345",4, 3);
    ProtectionObject Armor2 = new Armor("345",9, 5);
    ProtectionObject Armor3 = new Armor("345", 3, 3);
    ProtectionObject Armor4 = new Armor("345", 5, 2);

    Wand Wand11 = new Wand("123",7,5,3,9,5);
    Wand Wand12 = new Wand("324",7,3,3,9,9);
    AttackObject Wand1= Wand11.setAttackObject();
    ProtectionObject Wand2= Wand12.setProtectionObject();

    Sword Sword11 = new Sword("456",7,8,4,3,6);
    Sword Sword12 = new Sword("123",7,8,9,2,3);
    ProtectionObject Sword1 = Sword11.setProtectionObject();
    AttackObject Sword2= Sword12.setAttackObject();

    ArrayList<AttackObject> AttackObject1 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject3 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject5 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject7 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject10 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject1 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject3 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject5 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject7 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject10 = new ArrayList<>();


    Warrior warrior = new Warrior("123", 5, 6, 8, AttackObject1, ProtectionObject1);
    Warrior warrior2=new Warrior("345",8,8,7,AttackObject3,ProtectionObject3);
    Warrior warrior3=new Warrior("789",9,9,6,AttackObject5,ProtectionObject5);
    Warrior warrior4=new Warrior("234",9,9,4,AttackObject7,ProtectionObject7);
    Warrior warrior5=new Warrior("234",9,9,9,AttackObject10,ProtectionObject10);

    ArrayList<AttackObject> AttackObject2 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject2 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject4 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject4 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject6 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject6 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject8 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject8 = new ArrayList<>();
    ArrayList<AttackObject> AttackObject9 = new ArrayList<>();
    ArrayList<ProtectionObject> ProtectionObject9 = new ArrayList<>();
    Wizard wizard = new Wizard("567", 8, 9, 4, AttackObject2, ProtectionObject2);
    Wizard wizard2=new Wizard("234",8,7,8,AttackObject4,ProtectionObject4);
    Wizard wizard3=new Wizard("234",8,7,8,AttackObject6,ProtectionObject6);
    Wizard wizard4=new Wizard("234",8,7,8,AttackObject8,ProtectionObject8);
    Wizard wizard5=new Wizard("234",8,7,8,AttackObject9,ProtectionObject9);






    @Test
    void attack1() {
        Game game = new Game();
        warrior.addAttackObject(FireBallSpell4);
        wizard.addProtectionObject(Armor3);
        game.attack1(warrior, wizard);
        assertEquals(1, wizard.getLive());

        Game game2=new Game();
        warrior2.addAttackObject(Wand1);
        wizard2.addProtectionObject(Sword1);
        game2.attack1(warrior2,wizard2);
        assertEquals(2,wizard2.getLive());

        Game game3=new Game();
        warrior5.addAttackObject(Wand1);
        wizard5.addProtectionObject(Armor4);
        game3.attack1(warrior5,wizard5);
        assertEquals(0,wizard5.getLive());

    }

    @Test
    void attack2() {
        int turnos=4;
        Game game = new Game();
        warrior.addAttackObject(FireBallSpell1);
        warrior.addProtectionObject(Armor1);
        warrior.addProtectionObject(Armor2);
        wizard.addProtectionObject(Armor4);
        wizard.addAttackObject(FireBallSpell3);
        wizard.addAttackObject(FireBallSpell2);
        assertEquals(warrior,game.attack2(warrior,wizard,turnos));
        assertTrue(warrior.alive());

        int turnos1=2;
        Game game1=new Game();
        warrior3.addAttackObject(FireBallSpell1);
        warrior3.addAttackObject(FireBallSpell5);
        warrior3.addProtectionObject(Armor3);
        warrior3.addProtectionObject(Armor4);
        wizard3.addAttackObject(FireBallSpell2);
        wizard3.addAttackObject(FireBallSpell3);
        wizard3.addProtectionObject(Armor1);
        wizard3.addProtectionObject(Armor2);
        assertNull(game1.attack2(warrior3, wizard3, turnos1));

        int turnos2=3;
        Game game2=new Game();
        warrior4.addAttackObject(Sword2);
        warrior4.addAttackObject(FireBallSpell1);
        warrior4.addAttackObject(FireBallSpell2);
        warrior4.addProtectionObject(Armor1);
        wizard4.addAttackObject(FireBallSpell3);
        wizard4.addAttackObject(FireBallSpell4);
        wizard4.addProtectionObject(Wand2);
        wizard4.addProtectionObject(Armor2);
        wizard4.addProtectionObject(Armor3);
        assertEquals(wizard4,game2.attack2(warrior4,wizard4,turnos2));

    }
}