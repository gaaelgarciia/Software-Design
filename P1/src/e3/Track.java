package e3;

import java.util.Objects;

public record Track(String position, String recordingId,String Artist,String title,int duration ) {

    public String toString(){
        StringBuilder s = new StringBuilder(); //salta un warning ya que se podria hacer con un String, pero vemos más conveniente el uso de StringBuilder()
        s.append("Position: ").append(position).append("\n");
        s.append("Artist: ").append(Artist).append("\n");
        s.append("Title: ").append(title).append("\n");
        s.append("Duration: ").append(duration).append("\n");
        s.append("Recording ID: ").append(recordingId).append("\n");
        return String.valueOf(s);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track=(Track) obj;
        return recordingId.equals(track.recordingId); //Solo tendremos en cuenta para la igualdad la identificacion de la grabacion o que sean el mismo objeto (primera parte del if)
    }
    public int hashCode(){
        return Objects.hash(recordingId); //Solo tenemos en cuenta, al igual que en el equals, el identificador de la grabacion
    }
}


