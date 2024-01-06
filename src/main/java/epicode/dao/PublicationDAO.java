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

    public boolean findByIsbnToGenerateNewISBN(long isbn) {
        Publication exist = em.find(Publication.class, isbn);
        return exist != null;
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

    public Book findByAuthor(String author) {
        TypedQuery<Book> getAllQuerry = em.createQuery("SELECT a FROM Book a WHERE LOWER(a.author) LIKE :author", Book.class);
        getAllQuerry.setParameter("author", "%" + author.toLowerCase() + "%");
        System.out.println("------------Found by author -------------");
        List<Book> bookList = getAllQuerry.getResultList();
        bookList.forEach(System.out::println);

//        getting the first book
//        later make a scan to select a specific book


        if (bookList.isEmpty()) {
            System.out.println("Book by " + author + " did not found!");
            return null;
        } else {
            System.out.println("Book found!");
            System.out.println(bookList.get(0));
            return bookList.get(0);
        }
    }

    public Publication findByTitle(String title) {
        TypedQuery<Publication> getAllQuerry = em.createQuery("SELECT a FROM Publication a WHERE LOWER(a.title) LIKE :title", Publication.class);
        getAllQuerry.setParameter("title", "%" + title.toLowerCase() + "%");
        System.out.println("------------Found by title -------------");
        List<Publication> publicationList = getAllQuerry.getResultList();
        publicationList.forEach(System.out::println);

        //        getting the first book
//        later make a scan to select a specific book


        if (publicationList.isEmpty()) {
            System.out.println("Did not find a book called " + title + "!");
            return null;
        } else {
            System.out.println("Book found!");
            System.out.println(publicationList.get(0));
            return publicationList.get(0);
        }
    }

}
