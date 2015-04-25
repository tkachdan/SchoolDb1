package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by dan on 24.3.15.
 */
@Entity
public class Assignment extends AbstractEntity {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private Date date;
    @NotNull
    @ManyToOne
    private Teacher assignedBy;
    @NotNull
    @ManyToOne
    private Course course;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Teacher getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Teacher assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Course getCourse() {
        return course;
    }



    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment that = (Assignment) o;

        if (id != that.id) return false;
        if (assignedBy != null ? !assignedBy.equals(that.assignedBy) : that.assignedBy != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (assignedBy != null ? assignedBy.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", date=" + date +
                ", assignedBy=" + assignedBy +
                ", course=" + course +
                '}';
    }
}
