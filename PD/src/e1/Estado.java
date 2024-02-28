package e1;

public interface Estado {

void Reservar(Habitacion habitacion,String huesped,Hotel hotel);
void CancelarReserva(Habitacion habitacion,Hotel hotel);
void Limpiar(Habitacion habitacion,String Personal_limpieza,Hotel hotel);
void Liberar(Habitacion habitacion,Hotel hotel);
void AprobarLimpieza(Habitacion habitacion,String Supervisor,Hotel hotel);
boolean isAvailable();
String getEstado(Habitacion habitacion);
default void RevocarLimpieza(Habitacion habitacion,Hotel hotel){

}
}
