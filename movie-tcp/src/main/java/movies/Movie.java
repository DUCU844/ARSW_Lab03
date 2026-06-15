package movies;

import java.io.Serializable;

/**
 * This class represents a movie.
 * It implements Serializable so RMI can send it through the network.
 * TCP and HTTP still work the same way.
 */
public class Movie implements Serializable {
    private int id;
    private String title;
    private String director;
    private int year;
    public Movie(int id, String title, String director, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public int getId() {
        return id;
    }
    public String toText() {
        return id + "," + title + "," + director + "," + year;
    }
}