//@author Omkar Kadam, Colin Lee

package album;

import java.util.Objects;

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }

    @Override
    public int compareTo(Artist o) {
        if(!this.name.equalsIgnoreCase(o.getName()))
            return this.name.compareTo(o.getName());
        return this.born.compareTo(o.getBorn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) && Objects.equals(born, artist.born);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", born=" + born +
                '}';
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