package e1;

public class HabitacionLibre implements Estado{
    private static final HabitacionLibre instancia=new HabitacionLibre();
    private HabitacionLibre(){}
    public static HabitacionLibre getInstancia(){return instancia;}
    @Override
    public void Reservar(Habitacion habitacion,String huesped,Hotel hotel){
        throw new IllegalArgumentException("No se puede reservar una habitacion no disponible");

    }
    @Override
    public void CancelarReserva(Habitacion habitacion,Hotel hotel){
        //no podemos cancelar una habitacion no reservada
    }
    @Override
    public void Limpiar(Habitacion habitacion,String Personal_limpieza,Hotel hotel){
        habitacion.setPersonal_Limpieza(Personal_limpieza);
        habitacion.setEstado(HabitacionLimpia.getInstancia());
        hotel.addLimpia(habitacion);
        hotel.removeLibre(habitacion);
    }
    @Override
    public void Liberar(Habitacion habitacion,Hotel hotel){
        //No se puede liberar una habitacion libre
    }
    @Override
    public void AprobarLimpieza(Habitacion habitacion,String supervisor,Hotel hotel){
        //no se puede aprobar la limpieza de una habitacion no limpiada
    }
    @Override
    public boolean isAvailable(){
        return true;
    }
    @Override
    public String getEstado(Habitacion habitacion){

            return "Room no. " + habitacion.getNumHabitacion() + ": Free. Cleaning pending.";
    }
}
