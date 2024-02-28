package e1;



public class Habitacion {
    private int NumHabitacion;
    private String Supervisor;
    private String huesped;
    private String Personal_Limpieza;
    private Estado estado=HabitacionAprobada.getInstancia();
    public Habitacion(int NumHabitacion,String Supervisor){
        this.NumHabitacion=NumHabitacion;
        this.Supervisor=Supervisor;

    }
    public void Reservar(String huesped,Hotel hotel){
        estado.Reservar(this,huesped,hotel);
    }
    public void CancelarReserva(Hotel hotel){
        estado.CancelarReserva(this,hotel);
    }
    public void Limpiar(String Personal_limpieza,Hotel hotel){
        estado.Limpiar(this,Personal_limpieza,hotel);
    }
    public void Liberar(Hotel hotel){
        estado.Liberar(this,hotel);
    }
    public void AprobarLimpieza(String Supervisor,Hotel hotel){
        estado.AprobarLimpieza(this,Supervisor,hotel);
    }
    public void RevocarLimpieza(Hotel hotel){estado.RevocarLimpieza(this,hotel);}
    public String getEstado(){
        return estado.getEstado(this);
    }
    public boolean isAvailable(){return estado.isAvailable();}
    public int getNumHabitacion() {
        return NumHabitacion;
    }

    public String getHuesped() {
        return huesped;
    }

    public String getPersonal_Limpieza() {
        return Personal_Limpieza;
    }

    public String getSupervisor() {
        return Supervisor;
    }


    public void setNumHabitacion(int numHabitacion) {
        NumHabitacion = numHabitacion;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public void setPersonal_Limpieza(String personal_Limpieza) {
        Personal_Limpieza = personal_Limpieza;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


}
