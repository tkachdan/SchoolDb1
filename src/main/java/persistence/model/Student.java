package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class Student extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Column(unique = true)
    private String email;
    private double markAverage;

    @ManyToMany
    private Set<Course> attendedCouruses = new HashSet<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String exams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarkAverage() {
        return markAverage;
    }

    public void setMarkAverage(double markAverage) {
        this.markAverage = markAverage;
    }

    public Set<Course> getAttendedCourses() {
        return attendedCouruses;
    }

    public void setAttendedCourses(Set<Course> attendedCourses) {
        this.attendedCouruses = attendedCourses;
    }
}
