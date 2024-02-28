package e1;

public class HabitacionReservada implements Estado{
    private static final HabitacionReservada instancia=new HabitacionReservada();
    private HabitacionReservada(){}
    public static HabitacionReservada getInstancia(){return instancia;}
    @Override
    public void Reservar(Habitacion habitacion,String huesped,Hotel hotel){
        //No podemos reservar una habitacion ya reservada

    }
    @Override
    public void CancelarReserva(Habitacion habitacion,Hotel hotel){
        habitacion.setEstado(HabitacionAprobada.getInstancia());
        hotel.addAprobada(habitacion);

    }
    @Override
    public void Limpiar(Habitacion habitacion,String Personal_limpieza,Hotel hotel){
        throw new IllegalArgumentException("No se puede limpiar una habitacion ocupada");
    }
    @Override
    public void Liberar(Habitacion habitacion,Hotel hotel){
        habitacion.setEstado(HabitacionLibre.getInstancia());
        hotel.addLibre(habitacion);
    }
    @Override
    public void AprobarLimpieza(Habitacion habitacion,String supervisor,Hotel hotel){
        //No se puede aprobar la limpieza de una habitacion ocupada
    }
    @Override
    public boolean isAvailable(){
        return false;
    }
    @Override
    public String getEstado(Habitacion habitacion){

        return "Room no. " + habitacion.getNumHabitacion() + ": Booked by " + habitacion.getHuesped() + ". Occupied.";    }
}
