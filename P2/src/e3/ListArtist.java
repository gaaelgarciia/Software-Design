package e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListArtist extends ArrayList<Artist> {

    public void agregarArtista(Artist nombreArtista) {
        this.add(nombreArtista);
    }

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Artist artista : this) {
            sb.append(artista.getId()).append(", ");
            sb.append(artista.getName()).append(", ");
            sb.append(artista.getAverageratings()).append(", ");
            sb.append(artista.getGenres()).append(", ");
            sb.append(artista.getAlbum()).append(", ");
            sb.append(artista.getCountry()).append("\n");
        }
        return sb.toString();
    }
    public void sortByComparator (Comparator<Artist> comparator) {
        Collections.sort(this, comparator);
    }
    public void sortByDefaultOrder() {
        Collections.sort(this);
    }


}
