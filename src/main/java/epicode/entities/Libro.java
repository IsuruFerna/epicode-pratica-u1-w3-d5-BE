package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="libro")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Libro {
    @Id
    @Column(name="codice_isbn")
    @GeneratedValue
    private long codice_isbn;

    private String titolo;
    private LocalDate anno_publicazione;
    private int num_pagine;
    private String autore;
    private String genere;

    public Libro(String titolo, LocalDate anno_publicazione, int num_pagine, String autore, String genere) {
        this.titolo = titolo;
        this.anno_publicazione = anno_publicazione;
        this.num_pagine = num_pagine;
        this.autore = autore;
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnno_publicazione() {
        return anno_publicazione;
    }

    public void setAnno_publicazione(LocalDate anno_publicazione) {
        this.anno_publicazione = anno_publicazione;
    }

    public int getNum_pagine() {
        return num_pagine;
    }

    public void setNum_pagine(int num_pagine) {
        this.num_pagine = num_pagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
