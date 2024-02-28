package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void simularIncursion() {

        NodoCompuesto ataqueAereo=new AtaqueAereo("E","AirRaid",151,new NodoFin("K","End"));
        ataqueAereo.addNodo(ataqueAereo);

        NodoCompuesto batalla=new Batalla("B","Battle",20,30,25,new NodoFin("D","End"),ataqueAereo);
        batalla.addNodo(batalla);

        NodoCompuesto tormentaMarina2=new TormentaMarina("G","Maelstrom",67,new NodoFin("I","End"));
        tormentaMarina2.addNodo(tormentaMarina2);
        NodoCompuesto batalla2=new Batalla("F","Battle",30,17,41,new NodoFin("H","End"),tormentaMarina2);
        batalla2.addNodo(batalla2);
        NodoCompuesto tormentaMarina=new TormentaMarina("C","Maelstrom",20,batalla2);
        tormentaMarina.addNodo(tormentaMarina);
        NodoCompuesto avistamiento=new Avistamiento("A","WaypointSpotting",28,batalla,tormentaMarina);
        avistamiento.addNodo(avistamiento);

        Flota flotaA=new Flota(11,42,47,0,0);
        Flota flotaB=new Flota(1,25,0,46,28);

        Partida partida1=new Partida(flotaA,avistamiento);
        Partida partida2=new Partida(flotaB,avistamiento);
        assertEquals("Sortie Result:\n" +
                "SUCCESS\n" +
                "Last Visited Node: H\n" +
                "Final HP: 1",partida1.simularIncursion());
        assertEquals("Sortie Result:\n" +
                "FAIL\n" +
                "Last Visited Node: E\n" +
                "Final HP: -33",partida2.simularIncursion());
        assertEquals("Smallest Node Count to End: 3",partida1.minimoNodos());
        assertEquals("Smallest Node Count to End: 3",partida2.minimoNodos());
        assertEquals("(A WaypointSpotting, (B Battle, (D End), (E AirRaid, (K End))), (C Maelstrom, (F Battle, (H End), (G Maelstrom, (I End)))))",partida1.representarEstructuraNewick(avistamiento));
        assertEquals("(A WaypointSpotting, (B Battle, (D End), (E AirRaid, (K End))), (C Maelstrom, (F Battle, (H End), (G Maelstrom, (I End)))))",partida2.representarEstructuraNewick(avistamiento));

    }

    @Test
    void simularIncursion2(){
        NodoCompuesto tormentaMarinaM=new TormentaMarina("M","Maelstrom",30,new NodoFin("P","End"));
        tormentaMarinaM.addNodo(tormentaMarinaM);

        NodoCompuesto avistamientoI=new Avistamiento("I","WaypointSpotting",15, tormentaMarinaM, new NodoFin("N","End"));
        avistamientoI.addNodo(avistamientoI);

        NodoCompuesto ataqueAereoE=new AtaqueAereo("E","AirRaid",125, avistamientoI);
        ataqueAereoE.addNodo(ataqueAereoE);

        NodoCompuesto tormentaMarinaK=new TormentaMarina("K","Maelstrom",28,new NodoFin("O","End"));
        tormentaMarinaK.addNodo(tormentaMarinaK);

        NodoCompuesto avistamientoG=new Avistamiento("G","WaypointSpotting",35, tormentaMarinaK, new NodoFin("L","End"));
        avistamientoG.addNodo(avistamientoG);

        NodoCompuesto ataqueAereoF=new AtaqueAereo("F","AirRaid",110, new NodoFin("J","End"));
        ataqueAereoF.addNodo(ataqueAereoF);


        NodoCompuesto batalla2=new Batalla("D","Battle",10,35,35,avistamientoG,new NodoFin("H","End"));
        batalla2.addNodo(batalla2);

        NodoCompuesto tormentaMarina=new TormentaMarina("C","Maelstrom",15,ataqueAereoF);
        tormentaMarina.addNodo(tormentaMarina);

        NodoCompuesto batalla=new Batalla("B","Battle",25,20,15,batalla2,ataqueAereoE);
        batalla.addNodo(batalla);

        NodoCompuesto avistamiento=new Avistamiento("A","WaypointSpotting",15,batalla,tormentaMarina);
        avistamiento.addNodo(avistamiento);


        Flota flotaA=new Flota(15,30,55,10,20);

        Partida partida1=new Partida(flotaA,avistamiento);
        assertEquals("Sortie Result:\n" +
                "SUCCESS\n" +
                "Last Visited Node: L\n" +
                "Final HP: 10",partida1.simularIncursion());


        assertEquals("Smallest Node Count to End: 4",partida1.minimoNodos());
        assertEquals("(A WaypointSpotting, (B Battle, (D Battle, (G WaypointSpotting, (K Maelstrom, (O End)), (L End)), (H End)), (E AirRaid, (I WaypointSpotting, (M Maelstrom, (P End)), (N End)))), (C Maelstrom, (F AirRaid, (J End))))",partida1.representarEstructuraNewick(avistamiento));
    }
}