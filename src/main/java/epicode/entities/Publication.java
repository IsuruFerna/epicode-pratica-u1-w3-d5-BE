package epicode.entities;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "library_books")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Publication {
    @Id
    @GeneratedValue
    @Column(name="isbn_code", unique = true)
    private long ISBNcode;
    private String title;
    private int releasedYear;
    private int numPages;

    public Publication() {}

    @ManyToMany(mappedBy = "publications")
    private List<Borrowed> borroweds = new ArrayList<>();

    public Publication(String title, int releasedYear, int numPages) {
        this.title = title;
        this.releasedYear = LocalDate.of(releasedYear, 1, 1).getYear();
        this.numPages = numPages;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Publication.class.getSimpleName() + "[", "]")
                .add("CodicesISBN=" + ISBNcode)
                .add("releasedYear=" + releasedYear)
                .add("numPages=" + numPages)
                .toString();
    }
}
