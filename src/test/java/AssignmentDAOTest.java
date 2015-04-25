import junit.framework.Assert;
import org.junit.Test;
import persistence.DAO.Impl.AssignmentDAOImpl;
import persistence.DAO.Impl.CourseDAOImpl;
import persistence.model.Assignment;
import persistence.model.Course;

/**
 * Created by martin on 25.4.15.
 */
public class AssignmentDAOTest {
    AssignmentDAOImpl assignmentDAO = new AssignmentDAOImpl();

    @Test
    public void createTest() {
        Assignment assignment = new Assignment();
        assignmentDAO.createObject(assignment);
        Assert.assertEquals(assignment, assignmentDAO.readObjectById(assignment.getId()));
    }

    @Test
    public void deleteTest(){
        Assignment assignment = new Assignment();
        assignmentDAO.createObject(assignment);
        assignmentDAO.deleteObject(assignment.getId());
        Assert.assertNull(assignmentDAO.readObjectById(assignment.getId()));
    }

    @Test
    public void updateTest(){
        Assignment assignment = new Assignment();
        assignmentDAO.createObject(assignment);
        Course course = new Course();
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        courseDAO.createObject(course);
        assignment.setCourse(course);
        assignmentDAO.updateObject(assignment);
        Assert.assertEquals(assignment,assignmentDAO.readObjectById(assignment.getId()));
    }
}
