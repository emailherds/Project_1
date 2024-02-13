//@author Omkar Kadam, Colin Lee

package album;

import java.util.Scanner;

public class CollectionManager {

    public static void main(String[] args) {
        Collection collection = new Collection();
        run(collection);
    }

    /**
     Runs the collection manager and processes user input to modify the collection
     @param collection
     */
    public static void run(Collection collection) {
        System.out.println("Collection Manager is up running.");
        Scanner sc = new Scanner(System.in);
        String curr = sc.nextLine();
        System.out.println();
        while (!curr.equals("Q")) {
            if (curr.equals("")) {
                curr = sc.nextLine();
                continue;
            }
            String[] inputs = curr.split(",");
            String first = inputs[0];
            if (first.equals("PD")) {
                collection.printByDate();
                curr = sc.nextLine();
                continue;
            } else if (first.equals("PG")) {
                collection.printByGenre();
                curr = sc.nextLine();
                continue;
            } else if (first.equals("PR")) {
                collection.printByRating();
                curr = sc.nextLine();
                continue;
            } else if (inputs.length < 4) {
                System.out.println("Invalid command!");
                curr = sc.nextLine();
                continue;
            }
            String title = inputs[1];
            String artistName = inputs[2];
            String artistDOB = inputs[3];
            Date artistBorn = new Date(Integer.parseInt(artistDOB.split("/")[0]), Integer.parseInt(artistDOB.split("/")[1]), Integer.parseInt(artistDOB.split("/")[2]));
            Artist artist = new Artist(artistName, artistBorn);
            commands(first, inputs, title, artistName, artistDOB, artistBorn, artist, collection);
            curr = sc.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }

    public static void commands(String first, String[] inputs, String title, String artistName, String artistDOB, Date artistBorn, Artist artist, Collection collection) {
        if (first.equals("A")) {
            add(inputs, title, artistName, artistDOB, artistBorn, artist, collection);
        } else if (first.equals("D")) {
            delete(inputs, title, artistName, artistDOB, artistBorn, artist, collection);
        } else if (first.equals("R"))
            rate(inputs, title, artistName, artistDOB, artistBorn, artist, collection);
    }

    /**
     Adds an album to the collection from the user input

     @param inputs a string array of inputs from the user
     @param title the title of the album
     @param artistName the name of the artist
     @param artistDOB the date of birth of the artist
     @param artistBorn the date of birth of the artist
     @param artist the artist object
     @param collection the collection of albums
     */
    public static void add(String[] inputs, String title, String artistName, String artistDOB, Date artistBorn, Artist artist, Collection collection) {
        Genre genre = Genre.UNKNOWN;
        boolean containsEnum = false;
        for (Genre g : Genre.values()) {
            if (g.toString().equals(inputs[4].toUpperCase()))
                containsEnum = true;
        }
        if (containsEnum)
            genre = Genre.valueOf(inputs[4].toUpperCase());

        String released = inputs[5];
        Date release = new Date(Integer.parseInt(released.split("/")[0]), Integer.parseInt(released.split("/")[1]), Integer.parseInt(released.split("/")[2]));
        Album album = new Album(title, artist, genre, release);

        //Check if artist DOB is valid
        if (!artistBorn.isValid()) {
            System.out.println("Artist DOB: " + artistDOB + " is invalid.");
        }
        //Check if release date is valid
        else if (!release.isValid()) {
            System.out.println("Date Released: " + released + " is invalid.");
        } else if (collection.add(album))
            System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " added to the collection.");
        else
            System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " is already in the collection.");
    }

    /**
     Removes an album from the collection based on the user input

     @param inputs a string array of inputs from the user
     @param title the title of the album
     @param artistName the name of the artist
     @param artistDOB the date of birth of the artist
     @param artistBorn the date of birth of the artist
     @param artist the artist object
     @param collection the collection of albums
     */
    public static void delete(String[] inputs, String title, String artistName, String artistDOB, Date artistBorn, Artist artist, Collection collection) {
        if (collection.findA(title, artist) != -1) {
            collection.remove(collection.getAlbums()[collection.findA(title, artist)]);
            System.out.println(title + "(" + artistName + ":" + artistDOB + ") removed from the collection.");
        } else
            System.out.println(title + "(" + artistName + ":" + artistDOB + ") is not in the collection");
    }
    /**
     Rates an album in the collection from the user input

     @param inputs a string array of inputs from the user
     @param title the title of the album
     @param artistName the name of the artist
     @param artistDOB the date of birth of the artist
     @param artistBorn the date of birth of the artist
     @param artist the artist object
     @param collection the collection of albums
     */

    public static void rate(String[] inputs, String title, String artistName, String artistDOB, Date artistBorn, Artist artist, Collection collection) {
        int rating = Integer.parseInt(inputs[4]);
        if (rating < 1 || rating > 5)
            System.out.println("Invalid rating, rating scale is 1 to 5.");
        else {
            if (collection.findA(title, artist) == -1)
                System.out.println(title + "(" + artist + ") is not in the collection");
            else {
                Album album = collection.getAlbums()[collection.findA(title, artist)];
                collection.rate(album, rating);
                System.out.println("You rate " + rating + " for " + title + ":" + album.getReleased() + "(" + artistName + ")");
            }
        }
    }
}
