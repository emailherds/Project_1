/**
 Artist class which contains information about an artist (name and date of birth)
 @author Omkar Kadam, Colin Lee
 */

package album;


public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

    /**
     Constructor for Artist class
     @param name name of artist
     @param born date of birth of artist
     */
    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }

    /**
     Compares two artist based on name and DOB
     @param o other artist to compare artist with
     @return 0 if artists are equal, -1 if first artist is alphabetically or born before second artist, 1 if first artist is alphabetically or born after second artist
     */
    @Override
    public int compareTo(Artist o) {
        if(!this.getName().equalsIgnoreCase(o.getName()))
            return this.getName().compareTo(o.getName());
        return this.getBorn().compareTo(o.getBorn());
    }

    /**
     Checks equality between two artists
     @param o other artist to compare artist with
     @return true or false if artists are equal
     */
    @Override
    public boolean equals(Object o) {
        Artist artist = (Artist) o;
        return this.getName().equalsIgnoreCase(artist.getName()) && this.getBorn().compareTo(artist.getBorn()) == 0;
    }

    /**
     Prints artists name and DOB
     @return string of artist contents
     */
    @Override
    public String toString() {
        return name + ":" + born;
    }

    /**
     Get name of artist
     @return name of artist
     */
    public String getName() {
        return name;
    }

    /**
     Get date of birth of artist
     @return date of birth of artist
     */
    public Date getBorn() {
        return born;
    }

    /**
     Set name of artist
     @param name name of artist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     Set date of birth of artist
     @param born date of birth of artist
     */
    public void setBorn(Date born) {
        this.born = born;
    }

    /**
     Testbed for Artist class
     */
    public static void main(String[]args){
        Artist artist1 = new Artist("Baylor Swift", new Date(12,13,1989));
        Artist artist2 = new Artist("Taylor Swift", new Date(12,13,1989));

        Artist artist3 = new Artist("Taylor Swift", new Date(11,13,1988));
        Artist artist4 = new Artist("Taylor Swift", new Date(12,13,1989));

        Artist artist5 = new Artist("Taylor Swift", new Date(12,13,1989));
        Artist artist6 = new Artist("Baylor Swift", new Date(12,13,1989));

        Artist artist7 = new Artist("Taylor Swift", new Date(12,13,1989));
        Artist artist8 = new Artist("Taylor Swift", new Date(11,13,1988));

        Artist artist9 = new Artist("Taylor Swift", new Date(12,13,1989));
        Artist artist10 = new Artist("Taylor Swift", new Date(12,13,1989));

        System.out.println(artist1.compareTo(artist2));
        System.out.println(artist3.compareTo(artist4));
        System.out.println(artist5.compareTo(artist6));
        System.out.println(artist7.compareTo(artist8));
        System.out.println(artist9.compareTo(artist10));

    }
}