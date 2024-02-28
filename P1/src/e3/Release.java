package e3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
public class Release {
    private String id;
    private String title;
    private String Artist;
    private List<Track> trackList;
    public Release(String id){ //Constructor de Release
        if(id==null ||id.isEmpty()){
            throw new IllegalArgumentException("El id no puede ser nulo o vacio");
        }
        this.id=id;
        this.trackList=new ArrayList<>();
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return Artist;
    }
    public List<Track> getTrackList(){
        return trackList;
    }
    public void setId (String id){
        this.id=id;
    } //No se utiliza pero lo pide el propio enunciado
    public void setTitle(String title){
        this.title=title;
    }
    public void setArtist(String Artist){
        this.Artist=Artist;
    }
    public void setTrackList(List<Track> trackList){this.trackList=trackList;} //No se utiliza pero lo pide el propio enunciado
    public void addTrack(Track a) { //Utilizado para añadir pistas a la lista de pistas
        if (a != null) { //solo se añadira en el caso que el track sea no nulo
            trackList.add(a);
        }
        else
            throw new IllegalArgumentException("La pista debe de ser no nula"); //si es nulo lanzamos excepcion
    }
    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append("ID: ").append(id).append("\n");
        s.append("Title: ").append(title).append("\n");
        s.append("MainArtist: ").append(Artist).append("\n");
        s.append("Tracklist:\n");
        for(Track a : trackList){
            s.append(a.toString()).append("\n");
        }
        return s.toString();
    }
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }else if(obj==null || getClass() !=obj.getClass()){
            return false;
        }
        Release release=(Release) obj;
        return new HashSet<>(trackList).containsAll(release.trackList) && new HashSet<>(release.trackList).containsAll(trackList); // solo tenemos en cuenta las pistas en la comprobacion
    }
    public int hashCode(){
        return Objects.hash(new HashSet<>(trackList).containsAll(trackList));  // solo tenemos en cuenta las pistas en la comprobacion
    }
}
