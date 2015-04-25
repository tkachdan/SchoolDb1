package persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by martin on 24.4.15.
 */
@Entity
public class ExamResult extends AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Student student;

    @OneToOne
    private Exam exam;

    private Mark mark;

    public ExamResult() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamResult that = (ExamResult) o;

        if (id != that.id) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (exam != null ? !exam.equals(that.exam) : that.exam != null) return false;
        return mark == that.mark;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (exam != null ? exam.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }
}
