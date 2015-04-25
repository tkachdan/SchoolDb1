package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class Exam extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    private Date registrationFrom;
    @NotNull
    private Date cariageDate;
    @NotNull
    private Date registrationTill;

    @NotNull
    @OneToOne
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> registeredStudents = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    Set<Course> courses = new HashSet<>();

    public Exam() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationFrom() {
        return registrationFrom;
    }

    public void setRegistrationFrom(Date registrationFrom) {
        this.registrationFrom = registrationFrom;
    }

    public Date getCariageDate() {
        return cariageDate;
    }

    public void setCariageDate(Date cariageDate) {
        this.cariageDate = cariageDate;
    }

    public Date getRegistrationTill() {
        return registrationTill;
    }

    public void setRegistrationTill(Date registrationTill) {
        this.registrationTill = registrationTill;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Set<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (id != exam.id) return false;
        if (registrationFrom != null ? !registrationFrom.equals(exam.registrationFrom) : exam.registrationFrom != null)
            return false;
        if (cariageDate != null ? !cariageDate.equals(exam.cariageDate) : exam.cariageDate != null) return false;
        if (registrationTill != null ? !registrationTill.equals(exam.registrationTill) : exam.registrationTill != null)
            return false;
        if (teacher != null ? !teacher.equals(exam.teacher) : exam.teacher != null) return false;
        if (registeredStudents != null ? !registeredStudents.equals(exam.registeredStudents) : exam.registeredStudents != null)
            return false;
        return !(courses != null ? !courses.equals(exam.courses) : exam.courses != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (registrationFrom != null ? registrationFrom.hashCode() : 0);
        result = 31 * result + (cariageDate != null ? cariageDate.hashCode() : 0);
        result = 31 * result + (registrationTill != null ? registrationTill.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (registeredStudents != null ? registeredStudents.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        return result;
    }
}
