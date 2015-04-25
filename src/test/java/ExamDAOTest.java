import junit.framework.Assert;
import org.junit.Test;
import persistence.DAO.Impl.ExamDAOImpl;
import persistence.model.Exam;

import java.util.Date;

/**
 * Created by martin on 25.4.15.
 */
public class ExamDAOTest {
    ExamDAOImpl examDAO = new ExamDAOImpl();
    @Test
    public void createTest(){
        Exam exam = new Exam();
        examDAO.createObject(exam);
        Assert.assertEquals(exam, examDAO.readObjectById(exam.getId()));
    }

    @Test
    public void updateTest(){
        Exam exam = new Exam();
        examDAO.createObject(exam);
        exam.setRegistrationFrom(new Date());
        examDAO.updateObject(exam);
        Assert.assertEquals(exam, examDAO.readObjectById(exam.getId()));
    }

    @Test
    public void deleteTest(){
        Exam exam = new Exam();
        examDAO.createObject(exam);
        examDAO.deleteObject(exam.getId());
        Assert.assertNull(examDAO.readObjectById(exam.getId()));
    }
}
