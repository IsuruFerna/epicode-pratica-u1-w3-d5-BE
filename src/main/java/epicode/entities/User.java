package epicode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @Column(unique = true)
    private String cardNumber;

    public User(String name, String surname, LocalDate birthDate, String cardNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("birthDate=" + birthDate)
                .add("cardNumber='" + cardNumber + "'")
                .toString();
    }
}
