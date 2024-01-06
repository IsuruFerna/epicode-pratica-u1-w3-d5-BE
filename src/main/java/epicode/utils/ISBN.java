package epicode.utils;

import epicode.dao.PublicationDAO;

import javax.persistence.EntityManager;
import java.util.Random;

import static epicode.Application.emf;

// old isbn 10 digits
public class ISBN {

    // check on the data base
    EntityManager em = emf.createEntityManager();
    PublicationDAO pd = new PublicationDAO(em);

    public String generateIsbn() {
        String code;

        // validate isbn checking if the generated code already exsist inte db
        do {
            Random rdm = new Random();
            String group = String.valueOf(rdm.nextInt(0, 99));
            String title = String.valueOf(rdm.nextInt(0, 999));
            String publisher = String.valueOf(rdm.nextInt(0, 999));
            String chechDigit =  "-0";
            code = group + title + publisher + chechDigit;
            System.out.println("Code: " + code);
        } while (pd.findByIsbnToGenerateNewISBN(code));

        return code;
    }
}
