/**
 Genre enum which holds 5 possible genres
 @author Omkar Kadam, Colin Lee
 */

package album;

public enum Genre {
    POP("Pop"),
    COUNTRY("Country"),
    CLASSICAL("Classical"),
    JAZZ("Jazz"),
    UNKNOWN("Unknown");

    String displayName;

    Genre(String displayName){
        this.displayName = displayName;
    }
}

