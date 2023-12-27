package epicode;

import epicode.dao.UtenteDAO;
import epicode.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1w3d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        UtenteDAO user = new UtenteDAO(em);
        Utente u1 = new Utente("bob", "baa", LocalDate.parse("2000-01-01"), "22222222222");
        user.save(u1);


    }
}
