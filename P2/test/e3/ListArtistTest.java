package e3;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ListArtistTest {
    Artist a1=new Artist("123","miguel",7,"pop",4,"Spain");
    Artist a2=new Artist("456","luis",5,"rock",2,"England");
    Artist a3=new Artist("789","pedro",9,"trap",0,"Puerto Rico");
    Artist a4=new Artist("234","carlos",4,"techno",6,"Belgium");
    Artist a5=new Artist("654","lucas",8,"reggaeton",1,"Brazil");
    ListArtist lista=new ListArtist();

    @Test
    void agregarArtista() {
        lista.agregarArtista(a1);
        lista.agregarArtista(a2);
        lista.agregarArtista(a3);
        lista.agregarArtista(a4);
        lista.agregarArtista(a5);
    }

    @Test
    void testToString() {
        lista.agregarArtista(a2);
        lista.agregarArtista(a1);
        lista.agregarArtista(a4);
        assertEquals(lista.toString(),"456, luis, 5.0, rock, 2, England\n123, miguel, 7.0, pop, 4, Spain\n234, carlos, 4.0, techno, 6, Belgium\n");
        Collections.sort(lista);
        //ordena por id de menor a mayor
        assertEquals(lista.toString(),"123, miguel, 7.0, pop, 4, Spain\n234, carlos, 4.0, techno, 6, Belgium\n456, luis, 5.0, rock, 2, England\n");
    }

    @Test
    void sortByDefaultOrder() {
        lista.agregarArtista(a2);
        lista.agregarArtista(a1);
        lista.agregarArtista(a4);
        assertEquals(lista.toString(),"456, luis, 5.0, rock, 2, England\n123, miguel, 7.0, pop, 4, Spain\n234, carlos, 4.0, techno, 6, Belgium\n");
        lista.sortByDefaultOrder();
        //ordena por id de menor a mayor
        assertEquals(lista.toString(),"123, miguel, 7.0, pop, 4, Spain\n234, carlos, 4.0, techno, 6, Belgium\n456, luis, 5.0, rock, 2, England\n");

    }
}