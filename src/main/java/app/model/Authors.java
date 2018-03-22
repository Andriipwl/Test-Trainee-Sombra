package app.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    @Temporal(TemporalType.DATE)
    private java.util.Date born;

    @OneToMany(mappedBy = "authors", cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private List<Books> books= new ArrayList<>();

    public Authors() {
    }

    public Authors(String name, String gender,java.util.Date born) {
        this.name = name;
        this.gender = gender;
        this.born = born;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.util.Date getBorn() {
        return born;
    }

    public void setBorn(java.util.Date born) {
        this.born = born;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", born=" + born +
                '}';
    }
}
