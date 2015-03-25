package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private String name;
    @NotNull
    private int capacity;
    @NotNull
    private Date beginDate;
    @NotNull
    private Date endDate;

    @OneToMany
    Set<Exam> examSet = new HashSet<>();
}
