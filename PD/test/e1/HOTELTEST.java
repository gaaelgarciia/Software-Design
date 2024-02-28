package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HOTELTEST {


    @Test
    void Reservar(){
        Hotel NH=new Hotel("NH");
        Habitacion habitacion1=new Habitacion(1,"Juan");
        Habitacion habitacion2=new Habitacion(2,"Jorge");
        Habitacion habitacion3=new Habitacion(3,"Luis");
        assertEquals("NH",NH.getName());
        NH.addHabitacion(habitacion1);
        NH.addHabitacion(habitacion2);
        NH.addHabitacion(habitacion3);
        assertEquals("Room no. 1: Free. This room was approved by Juan.",habitacion1.getEstado());
        habitacion1.Reservar("Miguel",NH);
        assertEquals("Room no. 1: Booked by Miguel. Occupied.",habitacion1.getEstado());
        habitacion1.Liberar(NH);
        assertEquals("Room no. 1: Free. Cleaning pending.",habitacion1.getEstado());
        assertThrows(IllegalArgumentException.class,()->habitacion1.Reservar("Luis",NH));
        habitacion1.Limpiar("Alberto",NH);
        assertEquals("Alberto",habitacion1.getPersonal_Limpieza());
        assertEquals("Room no. 1: Free. Room cleaned by Alberto, pending approval.",habitacion1.getEstado());
        assertThrows(IllegalArgumentException.class,()->habitacion1.Reservar("Luis",NH));
        habitacion1.AprobarLimpieza("Carlos",NH);
        assertTrue(habitacion1.isAvailable());
        habitacion1.RevocarLimpieza(NH);
        assertEquals("Room no. 1: Free. Cleaning pending.",habitacion1.getEstado());
        habitacion1.Limpiar("Juan",NH);
        habitacion1.AprobarLimpieza("Jose",NH);
        assertEquals("Room no. 1: Free. This room was approved by Jose.",habitacion1.getEstado());
        habitacion1.Reservar("Luis",NH);
        habitacion1.CancelarReserva(NH);
        assertEquals("Room no. 1: Free. This room was approved by Jose.",habitacion1.getEstado());
        habitacion1.Reservar("Carla",NH);
        assertThrows(IllegalArgumentException.class,()->habitacion1.Limpiar("Luis",NH));
        assertFalse(habitacion1.isAvailable());
        habitacion1.Liberar(NH);
        habitacion1.Limpiar("Pedro",NH);
        assertTrue(habitacion1.isAvailable());
        habitacion2.Reservar("Martin",NH);
        assertEquals("""
                ***********************
                NH
                ***********************
                Room no. 1: Free. Room cleaned by Pedro, pending approval.
                Room no. 2: Booked by Martin. Occupied.
                Room no. 3: Free. This room was approved by Luis.
                ***********************
                """,NH.getRoomInfo());
        assertEquals("Room no. 3\n",NH.listaDisponibles());
        assertEquals("Room no. 1\n",NH.listaLimpias());
        Habitacion habitacion4=new Habitacion(4,"Samuel");
        NH.addHabitacion(habitacion4);
        habitacion4.Reservar("Jacobo",NH);
        habitacion4.Liberar(NH);
        assertEquals("Room no. 4\n",NH.listaNoLimpias());
        Habitacion habitacion5=new Habitacion(5,"Pedro");
        NH.addHabitacion(habitacion5);
        habitacion5.Reservar("Luis",NH);
        habitacion5.AprobarLimpieza("Manuel",NH);
        assertEquals("Room no. 5: Booked by Luis. Occupied.",habitacion5.getEstado());
        habitacion5.Liberar(NH);
        habitacion5.AprobarLimpieza("Carlos",NH);
        habitacion5.Liberar(NH);
        habitacion5.CancelarReserva(NH);
        assertEquals("Room no. 5: Free. Cleaning pending.",habitacion5.getEstado());
        habitacion5.Limpiar("Alberto",NH);
        habitacion5.Limpiar("Laura",NH);
        habitacion5.CancelarReserva(NH);
        habitacion5.Liberar(NH);
        assertEquals("Room no. 5: Free. Room cleaned by Alberto, pending approval.",habitacion5.getEstado());
        habitacion5.AprobarLimpieza("Sara",NH);
        habitacion5.CancelarReserva(NH);
        habitacion5.Limpiar("Marcos",NH);
        habitacion5.Liberar(NH);
        habitacion5.AprobarLimpieza("Marta",NH);
        assertEquals("Room no. 5: Free. This room was approved by Sara.",habitacion5.getEstado());






    }

}