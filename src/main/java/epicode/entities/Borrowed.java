package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Borrowed {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private boolean returnDateExpired;

    @ManyToMany
    @JoinTable(
            name = "borrowed_publication",
            joinColumns = @JoinColumn(name = "borrowed_id"),
            inverseJoinColumns = @JoinColumn(name = "publication_id")
    )
    private List<Publication> publications = new ArrayList<>();

    public Borrowed(User user, Publication publication, String borrowedDate, List<Publication> publications) {
        this.user = user;
        this.borrowedDate = LocalDate.parse(borrowedDate);
        this.returnDate = LocalDate.parse(borrowedDate).plusMonths(1);
        this.returnDateExpired = LocalDate.parse(borrowedDate).plusMonths(1).isAfter(LocalDate.now());
        this.publications = publications;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturnDateExpired() {
        return returnDateExpired;
    }

    public void setReturnDateExpired(boolean returnDateExpired) {
        this.returnDateExpired = returnDateExpired;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Borrowed.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("user=" + user)
                .add("borrowedDate=" + borrowedDate)
                .add("returnDate=" + returnDate)
                .add("returnDateExpired=" + returnDateExpired)
                .add("publications=" + publications)
                .toString();
    }
}
