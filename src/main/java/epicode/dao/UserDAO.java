package epicode.dao;

import epicode.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
        System.out.println("New user saved correctly!");
    }

    public User findByCardNum(String num) {
        TypedQuery<User> getAllQuerry = em.createQuery("SELECT a FROM User a WHERE a.cardNumber = :num", User.class);
        getAllQuerry.setParameter("num", num);
        List<User> users = getAllQuerry.getResultList();

        if (users.isEmpty()) {
            System.out.println("User with " + num + " did not found!");
            return null;
        } else {
            System.out.println("User found!");
            System.out.println(users.get(0));
            return users.get(0);
        }
    }
}
