import junit.framework.Assert;
import org.junit.Test;
import persistence.DAO.Impl.TeacherDAOImpl;
import persistence.model.Teacher;

/**
 * Created by martin on 25.4.15.
 */
public class TeacherDAOTest {
    TeacherDAOImpl teacherDAO = new TeacherDAOImpl();
    @Test
    public void createTest(){
        Teacher teacher = new Teacher("hello","address","lastName","firstName");
        teacherDAO.createObject(teacher);
        Assert.assertEquals(teacher,teacherDAO.readObjectById(teacher.getId()));
    }

    @Test
    public void deleteTest(){
        Teacher teacher = new Teacher("hello","address","lastName","firstName");
        teacherDAO.createObject(teacher);
        teacherDAO.deleteObject(teacher.getId());
        Assert.assertNull(teacherDAO.readObjectById(teacher.getId()));
    }

    @Test
    public void updateTest(){
        Teacher teacher = new Teacher("hello","address","lastName","firstName");
        teacherDAO.createObject(teacher);
        teacher.setAddress("newAdress");
        teacherDAO.updateObject(teacher);
        Assert.assertEquals(teacher,teacherDAO.readObjectById(teacher.getId()));
    }

}
