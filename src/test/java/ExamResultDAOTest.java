import junit.framework.Assert;
import org.junit.Test;
import persistence.DAO.Impl.ExamResultDAOImpl;
import persistence.model.ExamResult;
import persistence.model.Mark;

/**
 * Created by martin on 25.4.15.
 */
public class ExamResultDAOTest {
    ExamResultDAOImpl examResultDAO = new ExamResultDAOImpl();

    @Test
    public void createTest(){
        ExamResult examResult = new ExamResult();
        examResultDAO.createObject(examResult);
        Assert.assertEquals(examResult, examResultDAO.readObjectById(examResult.getId()));
    }

    @Test
    public void updateTest(){
        ExamResult examResult = new ExamResult();
        examResultDAO.createObject(examResult);
        examResult.setMark(Mark.A);
        examResultDAO.updateObject(examResult);
        Assert.assertEquals(examResult, examResultDAO.readObjectById(examResult.getId()));
    }

    @Test
    public void deleteTest(){
        ExamResult examResult = new ExamResult();
        examResultDAO.createObject(examResult);
        examResultDAO.deleteObject(examResult.getId());
        Assert.assertNull(examResultDAO.readObjectById(examResult.getId()));
    }
}
