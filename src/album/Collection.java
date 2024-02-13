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
    public int findA(String title, Artist artist){
        for(int i = 0; i < size; i++){
            if(albums[i].getTitle().equalsIgnoreCase(title) && albums[i].getArtist().equals(artist))
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
        if(size == 0)
            albums = new Album[4];
        else if(contains(album))
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
    public boolean remove(Album album) {
        System.out.println("\n\n");
        if (!contains(album))
            return false;

        boolean hit = false;
        for (int i = 0; i < size; i++) {
            if (albums[i].equals(album)) {
                hit = true;
            }
            if (hit && i < size - 1) {
                albums[i] = albums[i + 1];
            }
        }
        size--;
        return true;
    }

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
    public void printByDate() {
        if (size == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        System.out.println("* Collection sorted by Released Date/Title *");
        for (int i = 0; i < size; i++) {
            Album min = albums[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Album current = albums[j];
                if (min.getReleased().compareTo(current.getReleased()) > 0){
                    min = albums[j];
                    minIndex = j;
                }else if(min.getReleased().compareTo(current.getReleased()) == 0 && min.getTitle().compareTo(current.getTitle()) > 0){
                    min = albums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Album temp = albums[i];
                albums[i] = min;
                albums[minIndex] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(albums[i].toString());
        }
        System.out.println("* end of list *");
    }

    /**
     Prints all albums in collection/album array sorted by genre, then artist
     */
    public void printByGenre() {
        if (size == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        System.out.println("* Collection sorted by Genre/Artist *");
        for (int i = 0; i < size; i++) {
            Album min = albums[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Album current = albums[j];
                if (min.getGenre().compareTo(current.getGenre()) > 0){
                    min = albums[j];
                    minIndex = j;
                }else if(min.getGenre().compareTo(current.getGenre()) == 0 && min.getArtist().compareTo(current.getArtist()) > 0){
                    min = albums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Album temp = albums[i];
                albums[i] = min;
                albums[minIndex] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(albums[i].toString() + "\n");
        }
        System.out.println("* end of list *");
    }

    /**
     Prints all albums in collection/album array sorted by average rating, then title
     */

    public void printByRating() {
        if (size == 0) {
            System.out.println("Collection is empty!");
            return;
        }
        System.out.println("* Collection sorted by Rating/Title *");
        for (int i = 0; i < size; i++) {
            Album min = albums[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Album current = albums[j];
                if (min.avgRatings() > current.avgRatings() || (min.avgRatings() == current.avgRatings() && min.getTitle().compareTo(current.getTitle()) > 0)) {
                    min = albums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Album temp = albums[i];
                albums[i] = min;
                albums[minIndex] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(albums[i].toString() + "\n");
        }
        System.out.println("* end of list *");
    }

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