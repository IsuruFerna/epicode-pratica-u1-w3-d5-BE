package epicode.dao;

import epicode.entities.Book;
import epicode.entities.Publication;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public void findByRelasedYear(int year) {
        TypedQuery<Publication> getAllQuerry = em.createQuery("SELECT a FROM Publication a WHERE a.releasedYear = :year", Publication.class);
        getAllQuerry.setParameter("year", year);
        System.out.println("------------Found by released year -------------");
        getAllQuerry.getResultList().forEach(System.out::println);
    }

    public void findByAuthor(String author) {
        TypedQuery<Book> getAllQuerry = em.createQuery("SELECT a FROM Book a WHERE LOWER(a.author) LIKE :author", Book.class);
        getAllQuerry.setParameter("author", "%" + author.toLowerCase() + "%");
        System.out.println("------------Found by author -------------");
        getAllQuerry.getResultList().forEach(System.out::println);
    }

    public void findByTitle(String title) {
        TypedQuery<Publication> getAllQuerry = em.createQuery("SELECT a FROM Publication a WHERE LOWER(a.title) LIKE :title", Publication.class);
        getAllQuerry.setParameter("title", "%" + title.toLowerCase() + "%");
        System.out.println("------------Found by title -------------");
        getAllQuerry.getResultList().forEach(System.out::println);
    }

}
