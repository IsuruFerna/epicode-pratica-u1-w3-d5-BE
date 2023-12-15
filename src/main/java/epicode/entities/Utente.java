package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="utente")
public class Utente {
    @Id
    @Column(name = "user")
    @GeneratedValue
    private long id;

    private String nome;
    private String cognome;
    private LocalDate data_nascita;
    private String num_tessera;

    public Utente() {

    }

    public Utente(String nome, String cognome, LocalDate data_nascita, String num_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.num_tessera = num_tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getNum_tessera() {
        return num_tessera;
    }

    public void setNum_tessera(String num_tessera) {
        this.num_tessera = num_tessera;
    }
}
