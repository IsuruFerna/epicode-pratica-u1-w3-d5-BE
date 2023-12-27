package epicode;

import epicode.dao.UserDAO;
import epicode.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1w3d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UserDAO user = new UserDAO(em);

        User bob = new User("Bob", "Marley", "1999-02-02", "eeee");
        user.save(bob);
    }
}
