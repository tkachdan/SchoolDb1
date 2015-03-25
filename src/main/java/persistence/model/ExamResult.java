package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class ExamResult extends AbstractEntity {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private Date date;
    @NotNull
    @ManyToOne
    private Course course;
    @NotNull
    @ManyToOne
    private Student student;
    @NotNull
    @ManyToOne
    private Teacher teacher;

}
