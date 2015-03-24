package persistence.model;

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
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "sallary")
    private double sallary;
    @Column(name = "address")
    private String address;
    @Column(name = "mobileNumber")
    private String mobileNumber;
    @ManyToMany
    private Set<Course> lecturedCourses;

}
