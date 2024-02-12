///**
// Collection Manager class which reads and stores user input appropriately and calls relevant methods to perform user commands
// @author Omkar Kadam, Colin Lee
// */
//
//package album;
//
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class CollectionManager {
//
//    public static void main(String[] args){
//        Collection collection = new Collection();
//        run(collection);
//    }
//
//    public static void run(Collection collection){
//        System.out.println("Collection Manager is up running.");
//        Scanner sc = new Scanner(System.in);
//        String curr = sc.nextLine();
//        //loop till line is Q
//        while(!curr.equals("Q")){
//            //split line input into strings separated with comma, then put into variables
//            StringTokenizer inputs = new StringTokenizer(curr, ",");
//
//            String title = inputs.nextToken();
//            String artistName = inputs.nextToken();
//            String artistDOB = inputs.nextToken();
//            Date artistBorn = new Date(Integer.parseInt(artistDOB.split("/")[0]), Integer.parseInt(artistDOB.split("/")[1]), Integer.parseInt(artistDOB.split("/")[2]));
//
//            Artist artist = new Artist(artistName, artistBorn);
//
//            if(curr.charAt(0) == 'A'){
//                Genre genre = Genre.inputs.nextToken();
//                String released = inputs.nextToken();
//                Date release = new Date(Integer.parseInt(released.split("/")[0]), Integer.parseInt(released.split("/")[1]), Integer.parseInt(released.split("/")[2]));
//                Album album = new Album(title, artist, genre, release);
//
//                //Check if artist DOB is valid
//                if(!artistBorn.isValid()){
//                    System.out.println("Artist DOB: " + artistDOB  +" is invalid.");
//                    return;
//                }
//                //Check if release date is valid
//                if(!release.isValid()){
//                    System.out.println("Date Released: " + released  +" is invalid.");
//                    return;
//                }
//                //need to check
//                //An album with the same title and artist is already in the collection.
//                if(!release.isValid()){
//                    System.out.println(title + "(" + artistName + ":" + artistDOB + ")" + " is already in the collection.");
//                    return;
//                }
//                collection.add(album);
//            }
//            else if(curr.charAt(0) == 'D'){
//                collection.remove(collection.getAlbums()[collection.findA(title, artistName)]);
//            }
//            else if(curr.charAt(0) == 'R'){
//                collection.rate(collection.getAlbums()[collection.findA(title, artistName)], Integer.parseInt(inputs.nextToken()));
//            }
//            else if(curr.charAt(0) == 'P'){
//                if(curr.charAt(1) == 'D') {
//                    collection.printByDate();
//                }
//                else if(curr.charAt(1) == 'G') {
//                    collection.printByGenre();
//                }
//                else if(curr.charAt(1) == 'R') {
//                    collection.printByRating();
//                }
//            }
//            curr = sc.nextLine();
//        }
//        System.out.println("Collection Manager terminated.");
//    }
//}
