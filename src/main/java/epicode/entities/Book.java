package epicode.entities;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
public class Book extends Publication {
    private String author;
    private String genre;

    public Book() {}

    public Book(String title, int releasedYear, int numPages, String author, String genre) {
        super(title, releasedYear, numPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("author='" + author + "'")
                .add("genre='" + genre + "'")
                .toString();
    }
}
