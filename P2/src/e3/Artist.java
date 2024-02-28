package e3;
public class Artist implements Comparable<Artist> {
    private String name;
    private String Id;
    private double Averageratings;
    private String genres;
    private int album;
    private String country;
    public Artist(String id,String name,double AverageRatings,String genres,int album,String country){
        this.Id=id;
        this.name=name;
        this.Averageratings=AverageRatings;
        this.genres=genres;
        this.album=album;
        this.country=country;
    }

    public String getName() {
        return name;
    }
    public String getId(){
        return Id;
    }

    public double getAverageratings() {
        return Averageratings;
    }

    public String getGenres() {
        return genres;
    }

    public int getAlbum() {
        return album;
    }

    public String getCountry() {
        return country;
    }




    @Override
    public int compareTo(Artist other){
        return this.getId().compareTo(other.getId());
    }













}
