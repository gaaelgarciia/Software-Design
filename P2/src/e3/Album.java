package e3;

import java.util.Comparator;

public class Album implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        int respuesta=0;
        if(artist1.getAlbum() > artist2.getAlbum()){
            respuesta=-1;
        }else if(artist1.getAlbum() < artist2.getAlbum()){
            respuesta=1;
        }
        return respuesta;
    }

}
