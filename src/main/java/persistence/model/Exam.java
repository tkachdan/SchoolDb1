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
    @NotNull
    private Date cariageDate;
    private Date registrationFrom;
    @NotNull
    private Date registrationTill;
    @NotNull
    @OneToOne
    private Teacher teacher;

    @ManyToMany
    private Set<Student> registeredStudents = new HashSet<>();

    @OneToMany
    private Set<ExamResult> examResultSet = new HashSet<>();

    @OneToOne
    private Course course;


}
