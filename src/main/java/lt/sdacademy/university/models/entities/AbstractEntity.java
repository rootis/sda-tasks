package lt.sdacademy.university.models.entities;

public class AbstractEntity {

    private static final int ODD_PRIME = 31;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
