package e3;


import java.util.Comparator;


public class Eclecticism implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return artist1.getGenres().compareTo(artist2.getGenres());
    }

}
