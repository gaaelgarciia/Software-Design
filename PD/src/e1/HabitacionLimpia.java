package e1;

public class HabitacionLimpia implements Estado {
    private static final HabitacionLimpia instancia=new HabitacionLimpia();
    private HabitacionLimpia(){}
    public static HabitacionLimpia getInstancia(){return instancia;}
    @Override
    public void Reservar(Habitacion habitacion,String huesped,Hotel hotel){
        throw new IllegalArgumentException("No se puede reservar una habitacion no disponible");

    }
    @Override
    public void CancelarReserva(Habitacion habitacion,Hotel hotel){
        //no podemos cancelar la reserva de una habitacion no reservada
    }
    @Override
    public void Limpiar(Habitacion habitacion,String Personal_limpieza,Hotel hotel){
        //no podemos limpiar una habitacion ya limpia
    }
    @Override
    public void Liberar(Habitacion habitacion,Hotel hotel){
        //No se puede liberar una habitacion libre
    }
    @Override
    public void AprobarLimpieza(Habitacion habitacion,String supervisor,Hotel hotel){
        habitacion.setSupervisor(supervisor);
        habitacion.setEstado(HabitacionAprobada.getInstancia());
        hotel.addAprobada(habitacion);
        hotel.removeLimpia(habitacion);
    }
    @Override
    public boolean isAvailable(){
        return true;
    }
    @Override
    public String getEstado(Habitacion habitacion){

        return "Room no. " + habitacion.getNumHabitacion() + ": Free. Room cleaned by "+habitacion.getPersonal_Limpieza() + ", pending approval.";
    }
}


