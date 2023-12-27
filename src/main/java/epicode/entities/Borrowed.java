package epicode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Borrowed {
    @Id
    @GeneratedValue
    private long id;
    private User user;
    private Publication publication;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private boolean returnDateExpired;

    @ManyToMany(mappedBy = "users")
    private List<Publication> publications = new ArrayList<>();

    public Borrowed(User user, Publication publication, String borrowedDate, boolean returnDateExpired) {
        this.user = user;
        this.publication = publication;
        this.borrowedDate = LocalDate.parse(borrowedDate);
        this.returnDate = LocalDate.parse(borrowedDate).plusMonths(1);
        this.returnDateExpired = LocalDate.parse(borrowedDate).plusMonths(1).isAfter(LocalDate.now());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
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
                .add("publication=" + publication)
                .add("borrowedDate=" + borrowedDate)
                .add("returnDate=" + returnDate)
                .add("returnDateExpired=" + returnDateExpired)
                .add("publications=" + publications)
                .toString();
    }
}
