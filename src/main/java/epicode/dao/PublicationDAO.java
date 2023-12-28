package epicode.dao;

import epicode.entities.Publication;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PublicationDAO {
    private final EntityManager em;

    public PublicationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Publication a){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
        System.out.println("New item saved correctly!");
    }

    public void remove(long isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query removeByIsbn = em.createQuery("DELETE FROM Publication a WHERE a.ISBNcode = :isbn");
        removeByIsbn.setParameter("isbn", isbn);
        int numPublicationDeleted = removeByIsbn.executeUpdate();
        transaction.commit();

        if (numPublicationDeleted > 0) System.out.println("Item removed");
        else System.out.println("Did not find any item with " + isbn);
    }

}
