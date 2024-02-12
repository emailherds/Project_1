/**
 Collection class which contains an array of albums and methods to find, add, remove, and print albums in the collection
 @author Omkar Kadam, Colin Lee
 */
package album;

public class Collection {
    private static final int NOT_FOUND = -1;
    private Album[] albums; //list of albums
    private int size; //number of albums in the list

    /**
     Searches album array to see if certain album is present
     @param album album to find
     @return index of album in array
     */
    private int find(Album album){
        for(int i = 0; i < size; i++){
            if(album.equals(albums[i]))
                return i;
        }
        return NOT_FOUND;
    } //helper method

    /**
     Searches album array to see if album exists with same title and artist
     @param title title of album searching for
     @param artist artist of album searching for
     @return index of album in array
     */
    public int findA(String title, String artist){
        for(int i = 0; i < size; i++){
            if(albums[i].getTitle().equalsIgnoreCase(title) && albums[i].getArtist().getName().equalsIgnoreCase(artist))
                return i;
        }
        return NOT_FOUND;
    } //helper method

    /**
     Grows album array if it is full
     */
    private void grow(){
        Album[] newAlbum = new Album[albums.length + 4];
        for(int i = 0; i < albums.length; i++)
            newAlbum[i] = albums[i];
        albums = newAlbum;
    } //helper method to increase the capacity by 4

    /**
     Checks album array for album
     @param album album being searching for
     @return true of false if album is in array
     */
    public boolean contains(Album album){
        for(int i = 0; i < size; i++)
            if(albums[i].equals(album))
                return true;
        return false;
    }

    /**
     Adds album to array
     @param album album being added
     @return true of false if album is added
     */
    public boolean add(Album album){
        if(size == 0) {
            albums = new Album[4];
        }else if(contains(album))
            return false;
        albums[size] = album;
        size++;
        if(size == albums.length)
            grow();
        return true;
    } //false if the album exists

    /**
     Removes album from array
     @param album album being removed
     @return true of false if album is removed
     */
    public boolean remove(Album album){
        if(!contains(album))
            return false;
        boolean hit = false;
        for(int i = 0; i < albums.length; i++) {
            if(hit)
                albums[i] = albums[i+1];
            if (albums[i].equals(album)) {
                albums[i] = albums[i+1];
                hit = true;
            }
        }
        return true;
    } //false if the album doesn’t exist

    /**
     Rates an album
     @param album album being rated
     @param rating star rating for album
     */
    public void rate(Album album, int rating){
        album.rate(rating);
    }

    /**
     Prints all albums in collection/album array sorted by Date then title
     */
    public void printByDate(){
        for(int i = 0; i < size; i++){
            Album min = albums[i];
            for(int j = i; j < size; j++){
                Album current = albums[j];
                if(min.getReleased().compareTo(current.getReleased()) > 0){ //if min is greater than the current album
                    min = albums[j];
                }else if(min.getReleased().compareTo(current.getReleased()) == 0){
                    if(min.getTitle().compareTo(current.getTitle()) > 0)
                        min = albums[j];
                }
            }
            Album temp = albums[i];
            albums[i] = min;
            min = temp;
            System.out.println(albums[i].toString()+"\n");
        }
    } //sort by release date, then title

    /**
     Prints all albums in collection/album array sorted by genre, then artist
     */
    public void printByGenre(){
        for(int i = 0; i < size; i++){
            Album min = albums[i];
            for(int j = i; j < size; j++){
                Album current = albums[j];
                if(min.getGenre().compareTo(current.getGenre()) > 0){ //if min is greater than the current album
                    min = albums[j];
                }else if(min.getGenre().compareTo(current.getGenre()) == 0){
                    if(min.getArtist().compareTo(current.getArtist()) > 0)
                        min = albums[j];
                }
            }
            Album temp = albums[i];
            albums[i] = min;
            min = temp;
            System.out.println(albums[i].toString()+"\n");
        }
    } //sort by genre, then artist

    /**
     Prints all albums in collection/album array sorted by average rating, then title
     */
    public void printByRating(){
        for(int i = 0; i < size; i++){
            Album min = albums[i];
            for(int j = i; j < size; j++){
                Album current = albums[j];
                if(min.avgRatings() > current.avgRatings()){ //if min is greater than the current album
                    min = albums[j];
                }else if(min.avgRatings() == current.avgRatings()){
                    if(min.getTitle().compareTo(current.getTitle()) > 0)
                        min = albums[j];
                }
            }
            Album temp = albums[i];
            albums[i] = min;
            min = temp;
            System.out.println(albums[i].toString()+"\n");
        }
    }//sort by average rating, then title

    /**
     Set albums array
     @param albums albums array
     */
    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    /**
     Set albums array size
     @param size albums array size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     Get albums array
     @return  albums array
     */
    public Album[] getAlbums() {
        return albums;
    }

    /**
     Get albums array size
     @return  albums array size
     */
    public int getSize() {
        return size;
    }

}