package e1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String Name;
    private List<Habitacion> habitaciones;
    private List<Habitacion> habitacionLibres;
    private List <Habitacion> habitacionLimpias;
    private List <Habitacion> habitacionAprobadas;

    public Hotel(String name){
        this.Name=name;
        this.habitaciones=new ArrayList<>();
        this.habitacionLibres=new ArrayList<>();
        this.habitacionLimpias=new ArrayList<>();
        this.habitacionAprobadas=new ArrayList<>();

    }
    public void addHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
        habitacionAprobadas.add(habitacion);
    }
    public void addLibre(Habitacion habitacion){habitacionLibres.add(habitacion);}
    public void removeLibre(Habitacion habitacion){habitacionLibres.remove(habitacion);}
    public void addLimpia(Habitacion habitacion){
        habitacionLimpias.add(habitacion);
    }
    public void removeLimpia(Habitacion habitacion){habitacionLimpias.remove(habitacion);}
    public void addAprobada(Habitacion habitacion){
        habitacionAprobadas.add(habitacion);
    }
    public void removeAprobada(Habitacion habitacion){
        habitacionAprobadas.remove(habitacion);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getRoomInfo() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("***********************\n");
        roomInfo.append(Name).append("\n");
        roomInfo.append("***********************\n");

        for (Habitacion habitacion : habitaciones) {
            roomInfo.append(habitacion.getEstado()).append("\n");
        }

        roomInfo.append("***********************\n");

        // Devolver la información como una cadena
        return roomInfo.toString();
    }
    public String listaDisponibles(){
        StringBuilder availableRoomsList = new StringBuilder();
        for (Habitacion habitacion : habitacionAprobadas) {
            availableRoomsList.append("Room no. ").append(habitacion.getNumHabitacion()).append("\n");
        }
        // Devolver la lista de habitaciones disponibles como una cadena
        return availableRoomsList.toString();
    }

    public String listaNoLimpias(){
        StringBuilder uncleanRoomsList = new StringBuilder();
        for (Habitacion habitacion : habitacionLibres) {
            uncleanRoomsList.append("Room no. ").append(habitacion.getNumHabitacion()).append("\n");
        }
        // Devolver la lista de habitaciones no limpias como una cadena
        return uncleanRoomsList.toString();
    }
    public String listaLimpias(){
        StringBuilder cleanRoomsList = new StringBuilder();
        for (Habitacion habitacion : habitacionLimpias) {
            cleanRoomsList.append("Room no. ").append(habitacion.getNumHabitacion()).append("\n");
        }
        // Devolver la lista de habitaciones limpias como una cadena
        return cleanRoomsList.toString();
    }
}
