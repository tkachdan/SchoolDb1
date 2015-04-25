import persistence.DAO.Impl.CourseDAOImpl;
import persistence.DAO.Impl.StudentDAOImpl;
import persistence.model.Course;
import org.junit.Test;
import persistence.model.Student;

/**
 * Created by dan on 24.3.15.
 */
public class CoureseDAOTest {

    CourseDAOImpl courseDao = new CourseDAOImpl();
    StudentDAOImpl studentDAO = new StudentDAOImpl();
    @Test
    public void createTest() {
        Course course = new Course();
        course.setId(4);
        courseDao.createObject(course);
    }

    @Test
    public void createStrudent() {
        Student student = new Student("name", "lase", "mail-klokot");
        studentDAO.createObject(student);
    }


}
