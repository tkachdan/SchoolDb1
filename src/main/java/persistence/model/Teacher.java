package persistence.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class Teacher extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private double sallary;
    @NotNull
    private String address;
    @NotNull
    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> lecturedCourses = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String address, String email, String lastName, String firstName) {
        this.address = address;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getLecturedCourses() {
        return lecturedCourses;
    }

    public void setLecturedCourses(Set<Course> lecturedCourses) {
        this.lecturedCourses = lecturedCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (Double.compare(teacher.sallary, sallary) != 0) return false;
        if (address != null ? !address.equals(teacher.address) : teacher.address != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (firstName != null ? !firstName.equals(teacher.firstName) : teacher.firstName != null) return false;
        if (lastName != null ? !lastName.equals(teacher.lastName) : teacher.lastName != null) return false;
        if (lecturedCourses != null ? !lecturedCourses.equals(teacher.lecturedCourses) : teacher.lecturedCourses != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        temp = Double.doubleToLongBits(sallary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lecturedCourses != null ? lecturedCourses.hashCode() : 0);
        return result;
    }
}
