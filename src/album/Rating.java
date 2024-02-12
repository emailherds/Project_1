/**
 Rating class which holds the star rating as well as the next Rating in the linked list
 @author Omkar Kadam, Colin Lee
 */

package album;

public class Rating {
    private int star;
    private Rating next;

    /**
     Constructor for Rating class
     @param star star rating
     */
    public Rating(int star){
        setStar(star);
    }

    /**
     Get star rating
     @return star rating
     */
    public int getStar() {
        return star;
    }

    /**
     Get next star rating in linked list
     @return next star rating in linked list
     */
    public Rating getNext() {
        return next;
    }

    /**
     Set star rating
     @param star star ratings
     */
    public void setStar(int star) {
        this.star = star;
    }

    /**
     Set next star rating in linked list
     @param next next star rating in linked list
     */
    public void setNext(Rating next) {
        this.next = next;
    }

}
