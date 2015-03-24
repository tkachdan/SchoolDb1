package persistence.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class Exam extends AbstractEntity{
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Course course;
    @Column(name = "date")
    private Date date;
    @Column(name = "mark")
    private Mark mark;


    public Exam(Course course, Date date, Mark mark) {
        this.course = course;
        this.date = date;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", course=" + course +
                ", date=" + date +
                ", mark=" + mark +
                '}';
    }
}
