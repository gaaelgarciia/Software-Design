package e4;

import org.junit.jupiter.api.Test;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
class MesaBillarTest {
    public static MesaBillar a=new MesaBillar();
    public static MesaBillar b=new MesaBillar();
    public static MesaBillar c=new MesaBillar();
    public static MesaBillar d=new MesaBillar();



    @Test
    void testConstructorMesa(){
        MesaBillar mesaBillar=new MesaBillar();
        assertFalse(mesaBillar.esPartidaIniciada());
        assertTrue(mesaBillar.bolasMesa().isEmpty());
        assertTrue(mesaBillar.bolasCajetin().containsAll(Arrays.asList(BolaBillar.values())));

    }

    @Test
    void iniciarPartida() {
        a.iniciarPartida();
        assertTrue(a.esPartidaIniciada());
        assertThrows(IllegalArgumentException.class, () -> a.iniciarPartida());

    }

    @Test
    void meterBola() {
        assertThrows(IllegalArgumentException.class, () -> c.meterBola(BolaBillar.BOLA7));
        c.iniciarPartida();
        assertEquals("Has metido la bola en el cajetín",c.meterBola(BolaBillar.BOLA6));
        assertEquals(Arrays.asList(BolaBillar.BLANCA,BolaBillar.BOLA1,BolaBillar.BOLA2,BolaBillar.BOLA3,BolaBillar.BOLA4,BolaBillar.BOLA5,BolaBillar.BOLA7,BolaBillar.BOLA8,BolaBillar.BOLA9,BolaBillar.BOLA10,BolaBillar.BOLA11,BolaBillar.BOLA12,BolaBillar.BOLA13,BolaBillar.BOLA14,BolaBillar.BOLA15),c.bolasMesa());
        assertEquals(Arrays.asList(BolaBillar.BOLA6),c.bolasCajetin());
        assertEquals("Has metido la bola en el cajetín",c.meterBola(BolaBillar.BOLA13));
        assertEquals(Arrays.asList(BolaBillar.BLANCA,BolaBillar.BOLA1,BolaBillar.BOLA2,BolaBillar.BOLA3,BolaBillar.BOLA4,BolaBillar.BOLA5,BolaBillar.BOLA7,BolaBillar.BOLA8,BolaBillar.BOLA9,BolaBillar.BOLA10,BolaBillar.BOLA11,BolaBillar.BOLA12,BolaBillar.BOLA14,BolaBillar.BOLA15),c.bolasMesa());
        assertEquals(Arrays.asList(BolaBillar.BOLA6,BolaBillar.BOLA13),c.bolasCajetin());
        assertEquals("Bola blanca de nuevo en la mesa",c.meterBola(BolaBillar.BLANCA));
        assertEquals("La partida ha terminado",c.meterBola(BolaBillar.BOLA8));
        assertFalse(c.getpartidaEnMarcha());
        c.iniciarPartida();
        assertEquals("Has metido la bola en el cajetín",c.meterBola(BolaBillar.BOLA6));
        assertEquals("Has metido la bola en el cajetín",c.meterBola(BolaBillar.BOLA11));





    }

    @Test
    void bolasMesa() {
        assertTrue(c.bolasMesa().contains(BolaBillar.BOLA9));
        assertFalse(c.bolasMesa().contains(BolaBillar.BOLA6)); //Devolvera false ya que 7 ya no se encuentra en la mesa
    }

    @Test
    void bolasCajetin() {
        assertTrue(c.bolasCajetin().contains(BolaBillar.BOLA11));
        assertFalse(c.bolasCajetin().contains(BolaBillar.BLANCA));

    }

    @Test
    void esPartidaIniciada() {
        assertTrue(a.esPartidaIniciada());
        
    }

    @Test
    void obtenerGanador() {
        b.iniciarPartida();
        b.meterBola(BolaBillar.BOLA9);
        b.meterBola(BolaBillar.BOLA13);
        assertEquals("Va ganando el jugador de las bolas rayadas",b.obtenerGanador());
        b.meterBola(BolaBillar.BOLA1);
        b.meterBola(BolaBillar.BOLA2);
        b.meterBola(BolaBillar.BOLA3);
        assertEquals("Va ganando el jugador de las bolas lisas",b.obtenerGanador());
        b.meterBola(BolaBillar.BOLA10);
        assertEquals("Empate",b.obtenerGanador());
        b.meterBola(BolaBillar.BOLA4);
        b.meterBola(BolaBillar.BOLA5);
        b.meterBola(BolaBillar.BOLA6);
        b.meterBola(BolaBillar.BOLA7);
        assertEquals("Ha ganado el jugador de las bolas lisas",b.obtenerGanador());
    }
}
