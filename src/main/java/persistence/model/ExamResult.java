package persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by martin on 24.4.15.
 */
@Entity
public class ExamResult {

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
}
