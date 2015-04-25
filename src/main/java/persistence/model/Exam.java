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

    @ManyToMany
    private Set<Student> registeredStudents = new HashSet<Student>();

    @OneToMany
    Set<Course> courses = new HashSet<Course>();

    @Enumerated
    private Mark mark;

}
