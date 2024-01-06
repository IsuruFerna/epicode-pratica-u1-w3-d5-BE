package epicode.utils;

import epicode.Application;
import epicode.dao.PublicationDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Random;

import static epicode.Application.emf;


//        old isbn 10 digits
public class ISBN {
    EntityManager em = emf.createEntityManager();
    PublicationDAO pd = new PublicationDAO(em);
    private boolean comparator (String comp) {
//        String[] arr = {"111", "222", "333"};
//        return Arrays.stream(arr).anyMatch(str -> str.equalsIgnoreCase(comp));

        return pd.findByIsbnToGenerateNewISBN(comp);

    };

    public String generateIsbn() {
        String code;
        do {
            Random rdm = new Random();
            String group = String.valueOf(rdm.nextInt(0, 99));
            String title = String.valueOf(rdm.nextInt(0, 999));
            String publisher = String.valueOf(rdm.nextInt(0, 999));
            String chechDigit =  "-0";
            code = group + title + publisher + chechDigit;
            System.out.println("Code: " + code);
        } while (this.comparator("112"));

        return code;
    }
}
