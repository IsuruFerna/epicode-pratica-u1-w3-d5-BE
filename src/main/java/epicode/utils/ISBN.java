package epicode.utils;

import java.util.Random;

//        old isbn 10 digits
public class ISBN {

    public static String generateIsbn() {
        Random rdm = new Random();
        String group = String.valueOf(rdm.nextInt(0, 99));
        String title = String.valueOf(rdm.nextInt(0, 999));
        String publisher = String.valueOf(rdm.nextInt(0, 999));
        String chechDigit =  "-0";
        String code = group + title + publisher + chechDigit;
        System.out.println("Code: " + code);
        return code;
    }
}
