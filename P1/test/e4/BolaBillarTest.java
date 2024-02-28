package e4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class BolaBillarTest {

    @Test
    void get(){ //Lo utilizamos para comprobar que va bien el getNumber, getColour y getType
        assertEquals(2,BolaBillar.BOLA2.getNumber());
        assertEquals(" VERDE",BolaBillar.BOLA6.getColour());
        assertEquals(" RAYADA",BolaBillar.BOLA11.getType());
    }

}
