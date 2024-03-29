/**
 Album class which contains information about an album (title, artist, genre, release date, ratings)
 @author Omkar Kadam, Colin Lee
 */

package album;

import java.text.DecimalFormat;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //a linked list of ratings

    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     Constructor for Album class
     @param title title of album
     @param artist name of artist
     @param genre genre of album
     @param released release date of album
     */
    public Album(String title, Artist artist, Genre genre, Date released) {
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
        setReleased(released);
    }

    /**
     Add a rating of album to linked list
     @param star star rating of album
     */
    public void rate(int star) {
        if(ratings == null)
            ratings = new Rating(star);
        else {
            Rating rating = new Rating(star);
            rating.setNext(ratings);
            ratings = rating;
        }
    } //add a rating to the linked list

    /**
     Calculate average star rating from linked list
     @return average star rating of all ratings for album in linked list
     */
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

    /**
     Set title of album
     @param title title of album
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     Set artist of album
     @param artist artist of album
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     Set genre of album
     @param genre genre of album
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     Set release date of album
     @param released release date of album
     */
    public void setReleased(Date released) {
        this.released = released;
    }

    /**
     Set ratings of album
     @param ratings ratings of album
     */
    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    /**
     Get title of album
     @return title of album
     */
    public String getTitle() {
        return title;
    }

    /**
     Get artist of album
     @return artist of album
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     Get genre of album
     @return genre of album
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     Get release date of album
     @return release date of album
     */
    public Date getReleased() {
        return released;
    }

    /**
     Get ratings of album
     @return ratings of album
     */
    public Rating getRatings() {
        return ratings;
    }

    /**
     Prints albums information
     @return string of album contents
     */
    @Override
    public String toString() {
        return "[" + title + "] " +
                "Released " + released +
                " [" + artist.getName() + ":" + artist.getBorn() + "] " +
                "[" + genre.displayName + "] " +
                "Rating: " + getRatingsString();
    }

    /**
     Read ratings linked list and count number of star ratings for each star
     @return int array of count of stars
     */
    private String getRatingsString(){
        int[] ratingList = ratingsArr();
        if(ratings == null)
            return "none";
        return "*(" + ratingList[0] + ")**(" + ratingList[1] + ")***(" + ratingList[2] + ")****(" + ratingList[3] + ")*****(" + ratingList[4] +
        ")(average rating: " + df.format(avgRatings()) + ")";
    }

    /**
     Read ratings linked list and count number of star ratings for each star
     @return int array of count of stars
     */
    private int[] ratingsArr(){
        Rating tempRatings = this.getRatings();
        int[] ratingList = new int[5];
        while(tempRatings != null){
            ratingList[tempRatings.getStar()-1]++;
            tempRatings = tempRatings.getNext();
        }
        return ratingList;
    }

    /**
     Checks equality between two albums
     @param o other album to compare album with
     @return true or false if albums are equal
     */
    @Override
    public boolean equals(Object o) {
        Album album = (Album) o;
        return this.getTitle().equalsIgnoreCase(album.getTitle()) && this.getArtist().equals(album.getArtist());
    }
}