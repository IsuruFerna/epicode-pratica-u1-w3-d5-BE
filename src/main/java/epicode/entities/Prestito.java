package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codice_isbn", nullable = false)
    private Libro prestato;

    @ManyToOne
    @JoinColumn(name ="user", nullable = false)
    private Utente utente;

    LocalDate dataInizioPrestato;
    LocalDate dataRestituzionePrevista;
    boolean restituzioneEffettiva;

    public Prestito(Libro prestato, Utente utente, LocalDate dataInizioPrestato, boolean restituzioneEffettiva) {
        this.prestato = prestato;
        this.utente = utente;
        this.dataInizioPrestato = dataInizioPrestato;
        this.dataRestituzionePrevista = dataInizioPrestato.plusDays(30);
        this.restituzioneEffettiva = restituzioneEffettiva;
    }
}
