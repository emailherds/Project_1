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
        //loop till line is Q
        while(!curr.equals("Q")){
            //split line input into strings separated with comma, then put into variables
            StringTokenizer inputs = new StringTokenizer(curr, ",");

            String first = inputs.nextToken();
            String title = inputs.nextToken();
            String artistName = inputs.nextToken();
            String artistDOB = inputs.nextToken();
            Date artistBorn = new Date(Integer.parseInt(artistDOB.split("/")[0]), Integer.parseInt(artistDOB.split("/")[1]), Integer.parseInt(artistDOB.split("/")[2]));

            Artist artist = new Artist(artistName, artistBorn);

            if(first.equals("A")){
                Genre genre = Genre.valueOf(inputs.nextToken());
                String released = inputs.nextToken();
                Date release = new Date(Integer.parseInt(released.split("/")[0]), Integer.parseInt(released.split("/")[1]), Integer.parseInt(released.split("/")[2]));
                Album album = new Album(title, artist, genre, release);

                //Check if artist DOB is valid
                if(!artistBorn.isValid()){
                    System.out.println("Artist DOB: " + artistDOB  +" is invalid.");
                    return;
                }
                //Check if release date is valid
                if(!release.isValid()){
                    System.out.println("Date Released: " + released  +" is invalid.");
                    return;
                }
                //need to check
                //An album with the same title and artist is already in the collection.
                if(!release.isValid()){
                    System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " is already in the collection.");
                    return;
                }
                collection.add(album);
            }
            else if(first.equals("D")){
                collection.remove(collection.getAlbums()[collection.findA(title, artistName)]);
            }
            else if(first.equals("R")){
                collection.rate(collection.getAlbums()[collection.findA(title, artistName)], Integer.parseInt(inputs.nextToken()));
            }
            else if(first.equals("PD")) {
                collection.printByDate();
            }
            else if(first.equals("PG")) {
                collection.printByGenre();
            }
            else if(first.equals("PR")) {
                collection.printByRating();
            }
            curr = sc.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }
}
