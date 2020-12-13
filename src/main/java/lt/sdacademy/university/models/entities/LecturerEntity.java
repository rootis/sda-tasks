package lt.sdacademy.university.models.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
public class LecturerEntity extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
