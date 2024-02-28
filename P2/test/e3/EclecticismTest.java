package e3;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EclecticismTest {
    Artist a1=new Artist("123","miguel",7,"pop",4,"Spain");
    Artist a2=new Artist("456","luis",5,"rock",2,"England");
    Artist a3=new Artist("789","pedro",9,"trap",0,"Puerto Rico");
    ListArtist lista=new ListArtist();
    @Test
    void sortByComparator() {
        lista.agregarArtista(a2);
        lista.agregarArtista(a3);
        lista.agregarArtista(a1);
        assertEquals(lista.toString(),"456, luis, 5.0, rock, 2, England\n789, pedro, 9.0, trap, 0, Puerto Rico\n123, miguel, 7.0, pop, 4, Spain\n");
        lista.sortByComparator(new Eclecticism());
        //ordena por generos de menor a mayor
        assertEquals(lista.toString(),"123, miguel, 7.0, pop, 4, Spain\n456, luis, 5.0, rock, 2, England\n789, pedro, 9.0, trap, 0, Puerto Rico\n");
    }
}