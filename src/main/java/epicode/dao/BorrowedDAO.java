package epicode.dao;

import epicode.entities.Borrowed;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BorrowedDAO {
    private final EntityManager em;

    public BorrowedDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Borrowed a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
        System.out.println("User borrwed saved!");
    }
}
