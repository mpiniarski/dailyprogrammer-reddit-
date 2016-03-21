import java.util.Date;

/**
 * Created by marcin on 20.03.16.
 */
public class Livedates {
    public Date birthDate = null;
    public Date deathDate = null;

    public Livedates(Date birthDate, Date deathDate) {
        this.birthDate = (birthDate == null ? new Date() : birthDate);
        this.deathDate = (deathDate == null ? new Date() : deathDate);
    }
}
