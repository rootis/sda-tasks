package lt.sdacademy.movies.models.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Movie {

    Long id;

    @NotEmpty
    @Size(max = 250)
    String title;

    @NotNull
    Long categoryId;

    String description;

    Integer year;

    @Digits(integer = 2, fraction = 1)
    private BigDecimal imdbRating;

    public Movie() {
    }

    public Movie(Long id, @NotEmpty @Size(max = 250) String title, @NotNull Long categoryId, String description, Integer year, BigDecimal imdbRating) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
