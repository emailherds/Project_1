//@author Omkar Kadam, Colin Lee

package album;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    public static void main(String[] args){
        Collection collection = new Collection();
        run(collection);
    }

    public static void run(Collection collection){
        System.out.println("Collection Manager is up running.");
        Scanner sc = new Scanner(System.in);
        String curr = sc.nextLine();
        System.out.println();
        //loop till line is Q
        while(!curr.equals("Q")){
            //split line input into strings separated with comma, then put into variables
            if(curr == "") {
                curr = sc.nextLine();
                continue;
            }
            String[] inputs = curr.split(",");
            String first = inputs[0];
            if(first.equals("PD")) {
                collection.printByDate();
                curr = sc.nextLine();
                continue;
            }
            else if(first.equals("PG")) {
                collection.printByGenre();
                curr = sc.nextLine();
                continue;
            }
            else if(first.equals("PR")) {
                collection.printByRating();
                curr = sc.nextLine();
                continue;
            }
            else if(inputs.length < 4) {
                System.out.println("Invalid command!");
                curr = sc.nextLine();
                continue;
            }
            String title = inputs[1];
            String artistName = inputs[2];
            String artistDOB = inputs[3];
            Date artistBorn = new Date(Integer.parseInt(artistDOB.split("/")[0]), Integer.parseInt(artistDOB.split("/")[1]), Integer.parseInt(artistDOB.split("/")[2]));

            Artist artist = new Artist(artistName, artistBorn);

            if(first.equals("A")){
                Genre genre = Genre.UNKNOWN;
                boolean containsEnum = false;
                for(Genre g: Genre.values()){
                    if(g.equals(inputs[4].toUpperCase()))
                        containsEnum = true;
                }
                if(containsEnum)
                    genre = Genre.valueOf(inputs[4].toUpperCase());

                String released = inputs[5];
                Date release = new Date(Integer.parseInt(released.split("/")[0]), Integer.parseInt(released.split("/")[1]), Integer.parseInt(released.split("/")[2]));
                Album album = new Album(title, artist, genre, release);

                //Check if artist DOB is valid
                if(!artistBorn.isValid()){
                    System.out.println("Artist DOB: " + artistDOB  +" is invalid.");
                }
                //Check if release date is valid
                else if(!release.isValid()){
                    System.out.println("Date Released: " + released  +" is invalid.");
                }else if(collection.add(album))
                    System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " added to the collection.");
                else
                    System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " is already in the collection.");

            }
            else if(first.equals("D")){
                collection.remove(collection.getAlbums()[collection.findA(title, artist)]);
            }
            else if(first.equals("R")){
                int rating = Integer.parseInt(inputs[4]);
                if(rating < 1 || rating > 5)
                    System.out.println("Invalid rating, rating scale is 1 to 5.");
                else {
                    Album album = collection.getAlbums()[collection.findA(title, artist)];
                    collection.rate(album, rating);
                    System.out.println("You rate " + rating + " for " + title + ":" + album.getReleased().getMonth() + "/" + album.getReleased().getDay() + "/" + album.getReleased().getYear()  + "(" + artistName + ")");
                }

            }
            curr = sc.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }
}
