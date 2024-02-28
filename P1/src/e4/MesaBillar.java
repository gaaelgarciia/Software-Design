package e4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MesaBillar {

    private final ArrayList<BolaBillar> bolasMesa; //Creamos una lista que contendra elementos de tipo BolaBillar
    private final ArrayList<BolaBillar> bolasCajetin; //Creamos una lista que contendra elementos de tipo BolaBillar

    private boolean partidaEnMarcha;

    public MesaBillar(){
        this.partidaEnMarcha=false; //La partida comenará como no en marcha
        this.bolasMesa=new ArrayList<>();
        this.bolasCajetin=new ArrayList<>();
        bolasCajetin.addAll(Arrays.asList(BolaBillar.values())); //Metemos todas las bolas en el cajetin
        bolasMesa.clear(); //Nos aseguramos de que no haya bolas en la mesa



    }
    public boolean getpartidaEnMarcha(){
        return partidaEnMarcha; // comprobacion de si la partida está en marcha
    }

    public void iniciarPartida(){
        if(!partidaEnMarcha && bolasMesa.isEmpty()){ //La partida solo podra empezar si no hay una ya en marcha en esa mesa y no hay bolas en la mesa
            partidaEnMarcha=true;
            bolasMesa.addAll(Arrays.asList(BolaBillar.values())); //Ponemos todas las bolas en las mesa
            bolasCajetin.clear(); //Limpiamos la lista de bolas del cajetin
            System.out.println( "Partida iniciada,las bolas estan encima de la mesa"); //Lo usamos para comprobar cuando se inicia una partida, pero no lo usamos en el test

        }else{
            throw new IllegalArgumentException("No se puede iniciar la partida"); //En caso de que no se cumpla alguna de las dos condiciones lanzamos excepcion
        }

    }
    public String meterBola(BolaBillar bola){
        if(!partidaEnMarcha){
            throw new IllegalArgumentException("No empezo la partida"); //Si intentamos meter una bola sin estar la partida en marcha
        }else{
            if(bola.getNumber()>=1 && bola.getNumber()<=7 || bola.getNumber()>=9 && bola.getNumber()<=15){ //Si la bola añadida está dentro de las lisas (quitando la bola 8)o rayadas
                bolasMesa.remove(bola); //Quitamos la bola de la mesa
                bolasCajetin. add(bola); //Y la añadimos a el cajetin
                return "Has metido la bola en el cajetín"; //Utilizamos un return y no un system.out para poder comprobarlo en el test
            }else if(bola==BolaBillar.BLANCA){
                if(bolasMesa.isEmpty()){ //Introducimos esta casuistica ya que lo pide el enucniado, pero realmente nunca entrará en esta parte, ya que en el caso de que se hayan metido todas
                    partidaEnMarcha=false; //las bolas, al meterse la bola 8 ya se acabaria la partida y se limpiaria la mesa
                    return "La partida ya acabo";
                }else{
                    return "Bola blanca de nuevo en la mesa"; //Si metemos la bola blanca y hay otras bolas en la mesa indicamos que la bola blanca volverá a la mesa
                }

            }else if(bola==BolaBillar.BOLA8){ //en caso de que se meta
                partidaEnMarcha=false; //acabamos la partida y vaciamos las bolas
                bolasMesa.clear();
                return "La partida ha terminado";
            }
        }
        return "Error";
    }
    public List<BolaBillar> bolasMesa(){
       return bolasMesa;

    }
    public List<BolaBillar> bolasCajetin(){
        return bolasCajetin;
    }

    public  boolean  esPartidaIniciada() {
        return partidaEnMarcha; //devuelve el estado de la partida
    }
    public String obtenerGanador(){
        int bolasLisas=0; //creamos dos acumuladores
        int bolasRayadas=0;
        for(BolaBillar bolaBillar:bolasMesa){
            if(bolaBillar.getNumber()>=1 && bolaBillar.getNumber()<=7){
                bolasLisas++; //si la bola es lisa aumentamos el acumulador de lisas

            }else if(bolaBillar.getNumber()>=9 && bolaBillar.getNumber()<=15){
                bolasRayadas++; //si es rayada aumentamos el acumulador de rayadas
            }
        }
        if(bolasLisas==0){
            return "Ha ganado el jugador de las bolas lisas";
        }else if(bolasRayadas==0){
            return "Ha ganado el jugador de las bolas rayadas";

        }else if(bolasLisas<bolasRayadas){
            return "Va ganando el jugador de las bolas lisas";

        }else if(bolasRayadas<bolasLisas){
            return "Va ganando el jugador de las bolas rayadas";

        }else //Esto engloba el caso de que se haya metido la bola de 8 también
            return "Empate";
    }
}
