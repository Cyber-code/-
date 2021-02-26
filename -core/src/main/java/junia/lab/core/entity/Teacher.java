package junia.lab.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({ "reviews" }) //eviter les boucle infinie en formats JSON
public class Teacher extends GenericEntity implements Comparable<Teacher> {

    private String mail;

    private String password;

    private String role; //TODO Alaways Teacher

    private String enable; //TODO Alaways 1

    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "teacher")
    private Set<Review> reviews;

    public Teacher() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public int compareTo(Teacher o) {
        return Long.compare(o.getId(),getId());
    }
}
