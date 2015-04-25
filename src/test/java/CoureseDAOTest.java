import junit.framework.Assert;
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
        courseDao.createObject(course);
        Assert.assertEquals(course, courseDao.readObjectById(course.getId()));
    }

    @Test
    public void deleteTest(){
        Course course = new Course();
        courseDao.createObject(course);
        courseDao.deleteObject(course.getId());
        Assert.assertNull(courseDao.readObjectById(course.getId()));
    }

    @Test
    public void updateTest(){
        Course course = new Course();
        courseDao.createObject(course);
        course.setCapacity(123);
        courseDao.updateObject(course);
        Assert.assertEquals(course,courseDao.readObjectById(course.getId()));
    }




}
