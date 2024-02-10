package album;

public class Album {
    private Album[] albums; //list of albums
    private int size; //number of albums in the list
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //a linked list of ratings
    public void rate(int star) {

    } //add a rating to the linked list
    public double avgRatings() {

    } //compute the average ratings

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public Date getReleased() {
        return released;
    }

    public Rating getRatings() {
        return ratings;
    }
}