package lt.sdacademy.movies.models.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Movie {

    private Long id;

    @NotEmpty
    @Size(max = 250)
    private String title;

    @NotNull
    private Category category;

    private String description;

    private Integer year;

    @Digits(integer = 2, fraction = 1)
    private BigDecimal imdbRating;

    public Movie() {
    }

    public Movie(Long id, @NotEmpty @Size(max = 250) String title, @NotNull Category category, String description, Integer year,
        @Digits(integer = 2, fraction = 1) BigDecimal imdbRating) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.year = year;
        this.imdbRating = imdbRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(BigDecimal imdbRating) {
        this.imdbRating = imdbRating;
    }
}
