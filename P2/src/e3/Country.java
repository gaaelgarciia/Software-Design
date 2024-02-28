package e3;

import java.util.Comparator;

public class Country implements Comparator<Artist> {
    @Override
    public int compare(Artist artist1, Artist artist2) {
        return artist1.getCountry().compareTo(artist2.getCountry());
    }

}
