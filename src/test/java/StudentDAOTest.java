import junit.framework.Assert;
import org.junit.Test;
import persistence.DAO.Impl.StudentDAOImpl;
import persistence.model.Student;

/**
 * Created by martin on 25.4.15.
 */
public class StudentDAOTest {
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    @Test
    public void createTest(){
        Student student = new Student();
        studentDAO.createObject(student);
        Assert.assertEquals(student, studentDAO.readObjectById(student.getId()));
    }

    @Test
    public void updateTest(){
        Student student = new Student();
        studentDAO.createObject(student);
        student.setEmail("asd");
        studentDAO.updateObject(student);
        Assert.assertEquals(student, studentDAO.readObjectById(student.getId()));
    }

    @Test
    public void deleteTest(){
        Student student = new Student();
        studentDAO.createObject(student);
        studentDAO.deleteObject(student.getId());
        Assert.assertNull(studentDAO.readObjectById(student.getId()));
    }
}
