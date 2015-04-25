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
}
