package album;

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

    @Override
    public int compareTo(Artist o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public Date getBorn() {
        return born;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
}