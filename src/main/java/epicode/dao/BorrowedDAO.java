package epicode.dao;

import epicode.entities.Book;
import epicode.entities.Borrowed;
import epicode.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public void borrowedByCardNumber(String cardNum) {
        // u = user
        // b = borrowed

        Query getAllQuery = em.createQuery("SELECT b FROM Borrowed b JOIN b.user u WHERE u.cardNumber = :cardNum");
        getAllQuery.setParameter("cardNum", cardNum);

        System.out.println("--------- List user borrowed -----------");

        List<Borrowed> borrowedList = getAllQuery.getResultList();
        borrowedList.stream()
                        .flatMap(borrowed -> borrowed.getPublications().stream())
                                .forEach(System.out::println);

    }

    public void findAllReturnDateExpired() {
        Query getAllQuery = em.createQuery("SELECT e FROM Borrowed e WHERE e.returnDateExpired = true");
        List<Borrowed> borrowedList = getAllQuery.getResultList();

        System.out.println("---------- Return date expirede ----------");

        borrowedList.forEach(System.out::println);
    }

}
