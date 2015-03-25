package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
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
    private String lastName;
    @NotNull
    private String email;
    private double markAverage;

    @ManyToMany
    private Set<Course> attendedCourses;

    @OneToMany
    private Set<Assignment> assignedCourses;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
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
        return attendedCourses;
    }

    public void setAttendedCourses(Set<Course> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public Set<Assignment> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(Set<Assignment> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (Double.compare(student.markAverage, markAverage) != 0) return false;
        if (assignedCourses != null ? !assignedCourses.equals(student.assignedCourses) : student.assignedCourses != null)
            return false;
        if (attendedCourses != null ? !attendedCourses.equals(student.attendedCourses) : student.attendedCourses != null)
            return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(markAverage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (attendedCourses != null ? attendedCourses.hashCode() : 0);
        result = 31 * result + (assignedCourses != null ? assignedCourses.hashCode() : 0);
        return result;
    }
}
