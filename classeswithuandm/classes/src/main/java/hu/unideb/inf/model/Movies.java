package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movies {

    @Id
    @GeneratedValue
    private Integer id;
    private String Title;
    private int LengthHour;
    private int LengthMin;
    private String genre;

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    private int release;
    private String About;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getLengthHour() {
        return LengthHour;
    }

    public void setLengthHour(int lengthh) {
        this.LengthHour = lengthh;
    }

    public double getLengthMin() {
        return LengthMin;
    }

    public void setLengthMin(int lengthm) {
        this.LengthMin = lengthm;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}
