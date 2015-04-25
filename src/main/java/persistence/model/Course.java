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
public class Course extends AbstractEntity {


    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private int capacity;
    @NotNull
    private Date beginDate;
    @OneToOne
    private Assignment assignment;
    @NotNull
    private Date endDate;

    public Course() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (capacity != course.capacity) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (beginDate != null ? !beginDate.equals(course.beginDate) : course.beginDate != null) return false;
        if (assignment != null ? !assignment.equals(course.assignment) : course.assignment != null) return false;
        return !(endDate != null ? !endDate.equals(course.endDate) : course.endDate != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (assignment != null ? assignment.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
