//@author Omkar Kadam, Colin Lee

package album;

public class Collection {
    private static final int NOT_FOUND = -1;
    private Album[] albums; //list of albums
    private int size; //number of albums in the list

    private int find(Album album){
        for(int i = 0; i < size; i++){
            if(album.equals(albums[i]))
                return i;
        }
        return NOT_FOUND;
    } //helper method

    public int findA(String title, String artist){
        for(int i = 0; i < size; i++){
            if(albums[i].getTitle().equalsIgnoreCase(title) && albums[i].getArtist().getName().equalsIgnoreCase(artist))
                return i;
        }
        return NOT_FOUND;
    } //helper method

    private void grow(){
        Album[] newAlbum = new Album[albums.length + 4];
        for(int i = 0; i < albums.length; i++)
            newAlbum[i] = albums[i];
        albums = newAlbum;
    } //helper method to increase the capacity by 4

    public boolean contains(Album album){
        for(int i = 0; i < albums.length; i++)
            if(albums[i].equals(album))
                return true;
        return false;
    }

    public boolean add(Album album){
        if(contains(album))
            return false;
        albums[size] = album;
        size++;
        return true;
    } //false if the album exists

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

    public void rate(Album album, int rating){
        album.rate(rating);
    }

    public void printByDate(){

    } //sort by release date, then title

    public void printByGenre(){

    } //sort by genre, then artist

    public void printByRating(){

    }//sort by average rating, then title

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public int getSize() {
        return size;
    }

}