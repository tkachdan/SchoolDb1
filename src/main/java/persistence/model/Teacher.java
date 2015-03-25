package persistence.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dan on 11.3.15.
 */
@Entity
public class Teacher extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private double sallary;
    private String address;
    @NotNull
    private String email;
    @ManyToMany
    private Set<Course> lecturedCourses;

}
