package epicode;

import epicode.dao.PublicationDAO;
import epicode.dao.UserDAO;
import epicode.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1w3d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UserDAO user = new UserDAO(em);
        PublicationDAO pd = new PublicationDAO(em);


//        User bob = new User("Bob", "Marley", "1999-02-02", "eeee");
//        user.save(bob);

        Book book1 = new Book(2010, 150, "Bob", "fantacy");
        Magazine mag1 = new Magazine(2013, 50, Period.MONTHLY);

//        pd.save(book1);
//        pd.save(mag1);

        pd.remove(4);


    }
}
