//@author Omkar Kadam, Colin Lee
package album;

import java.util.Objects;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //a linked list of ratings

    public Album(String title, Artist artist, Genre genre, Date released) {
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
        setReleased(released);
    }

    public void rate(int star) {
        if(ratings == null)
            ratings = new Rating(star);
        else {
            Rating rating = new Rating(star);
            rating.setNext(ratings);
            ratings = rating;
        }
    } //add a rating to the linked list

    public double avgRatings() {
        double sum = 0.0;
        double count = 0.0;
        Rating pointer = ratings;
        while(pointer != null) {
            sum += pointer.getStar();
            pointer = pointer.getNext();
            count++;
        }
        return sum/count;
    } //compute the average ratings

    public void setAlbums(Album[] albums) {
//        this.albums = albums;
    }

    public void setSize(int size) {
        //this.size = size;
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

    /*
    public Album[] getAlbums() {
        //return albums;
    }
    */


    public int getSize() {
        return 1;
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

    @Override
    public String toString() {
        int[] ratingList = ratingsArr();
        return "[" + title + "] " +
                "Released " + released +
                "[" + artist + ":" + artist.getBorn() + "] " +
                "[" + genre + "] " +
                "Rating: *(" + ratingList[0] + ")**(" + ratingList[1] + ")***(" + ratingList[2] + ")****(" + ratingList[3] + ")*****(" + ratingList[4] +
                ")(average rating: " + avgRatings() + ")";
    }

    private int[] ratingsArr(){
        Rating tempRatings = this.getRatings();
        int[] ratingList = new int[5];
        while(tempRatings != null){
            ratingList[tempRatings.getStar()]++;
            tempRatings = tempRatings.getNext();
        }
        return ratingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(title, album.title) && Objects.equals(artist, album.artist);
    }

    public static void main(String[] args){
//        Album a = new Album();
//        a.rate(1);
//        a.rate(2);
//        a.rate(3);
//        System.out.println(a.avgRatings());
    }
}