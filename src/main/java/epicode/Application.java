package epicode;

import epicode.dao.BorrowedDAO;
import epicode.dao.PublicationDAO;
import epicode.dao.UserDAO;
import epicode.entities.*;
import epicode.utils.ISBN;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1w3d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UserDAO user = new UserDAO(em);
        PublicationDAO pd = new PublicationDAO(em);
        BorrowedDAO bd = new BorrowedDAO(em);


        User bob = new User("Bob", "Marley", "1999-02-02", "eeee");
        User foo = new User("Foo", "Bar", "1999-02-02", "ffff");
        User baz = new User("Baz", "Baa", "1999-02-02", "gggg");
//        user.save(bob);
//        user.save(foo);
//        user.save(baz);

        Book book1 = new Book("Bob's jurney",2010, 150, "Bob", "fantacy");
        Book book2 = new Book("Amda returns",2010, 350, "Foo", "horror");
        Magazine mag1 = new Magazine("How to bake cookies",2013, 50, Period.MONTHLY);

//        pd.save(book1);
//        pd.save(book2);
//        pd.save(mag1);
//        pd.remove(4);

        pd.findByRelasedYear(2010);
        pd.findByAuthor("ob");
        pd.findByTitle("amda");
        user.findByCardNum("eeee");

        List<Publication> listBorrowed= new ArrayList<>();
        listBorrowed.add(pd.findByTitle("amda"));
        listBorrowed.add(pd.findByTitle("amda"));

        Borrowed b1 = new Borrowed(user.findByCardNum("eeee"), LocalDate.now().minusDays(5).toString(), listBorrowed);
        Borrowed b2 = new Borrowed(user.findByCardNum("ffff"), LocalDate.now().minusDays(5).toString(), listBorrowed);
        Borrowed b3 = new Borrowed(user.findByCardNum("gggg"), LocalDate.now().minusDays(5).toString(), listBorrowed);
//        bd.save(b1);
//        bd.save(b2);
//        bd.save(b3);

        bd.borrowedByCardNumber("eeee");
        bd.findAllReturnDateExpired();

        ISBN.generateIsbn();


    }
}
