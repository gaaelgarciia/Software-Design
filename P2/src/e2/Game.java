package e2;


public class Game {

    public void attack1(Character character1, Character character2){
        character1.attack(character2);
    }

    public Character attack2(Character character1, Character character2,int turnos) {
        do {
            character1.attack(character2);
            character2.attack(character1);
            turnos--;
        } while ((character1.getLive() > 0) && (character2.getLive() > 0) && turnos > 0);
        if (character1.getLive() <= 0) {
            return character2;
        } else if (character2.getLive()<=0){return character1;}
        else
            return null;
    }
}
