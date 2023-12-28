package epicode.entities;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
public class Magazine extends Publication {
    private Period period;

    public Magazine(int releasedYear, int numPages, Period period) {
        super(releasedYear, numPages);
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Magazine.class.getSimpleName() + "[", "]")
                .add("period=" + period)
                .toString();
    }
}
