package e3;

import java.util.Comparator;

public  class AverageRatings  implements Comparator<Artist> {

    @Override
    public int compare(Artist artist1, Artist artist2) {
       int respuesta=0;
       if(artist1.getAverageratings() > artist2.getAverageratings()){
           respuesta=1;
       }else if(artist1.getAverageratings() < artist2.getAverageratings()){
           respuesta=-1;
       }
       return respuesta;
    }


}
