import persistence.DAO.Impl.CourseDAOImpl;
import junit.framework.Assert;
import persistence.DAO.Impl.StudentDAOImpl;
import persistence.model.Assignment;
import persistence.model.Course;
import org.junit.Test;
import persistence.model.Student;

/**
 * Created by dan on 24.3.15.
 */
public class CoureseDAOTest {

    CourseDAOImpl courseNewDao = new CourseDAOImpl();
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Test
    public void createTest() {


    }

    @Test
    public void createStrudent() {
        Student student = new Student("name", "lase", "mail-klokot");
        studentDAO.createObject(student);

    }


}
