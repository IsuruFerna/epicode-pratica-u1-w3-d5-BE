package epicode.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="rivista")
public class Rivista extends Libro{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
    public Rivista(String titolo, LocalDate anno_publicazione, int num_pagine, String autore, String genere, Periodicita periodicita) {
        super(titolo, anno_publicazione, num_pagine, autore, genere);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
