package e1;

public class HabitacionAprobada implements Estado{
    private static final HabitacionAprobada instancia=new HabitacionAprobada();
    private HabitacionAprobada(){}
    public static HabitacionAprobada getInstancia(){return instancia;}
    @Override
    public void Reservar(Habitacion habitacion,String huesped,Hotel hotel){

        habitacion.setHuesped(huesped);
        habitacion.setEstado(HabitacionReservada.getInstancia());
        hotel.removeAprobada(habitacion);


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
        //no podemos aprobar la limpieza de una habitacion ya aprobada

    }
    @Override
    public boolean isAvailable(){
        return true;
    }
    @Override
    public String getEstado(Habitacion habitacion){

        return "Room no. " + habitacion.getNumHabitacion() + ": Free. This room was approved by " +habitacion.getSupervisor()+".";
    }
    @Override
    public void RevocarLimpieza(Habitacion habitacion,Hotel hotel){

        habitacion.setEstado(HabitacionLibre.getInstancia());
        hotel.removeAprobada(habitacion);

    }
}
