package persistence.DAO.Impl;

import persistence.model.Exam;

import java.util.Collection;

/**
 * Created by martin on 25.4.15.
 */
public class ExamDAOImpl extends DAOImpl<Exam> {

    @Override
    public int createObject(Exam exam) {
        return super.createObject(exam);
    }


    public Exam readObjectById(int id) {
        return super.readObjectById(id, Exam.class);
    }

    @Override
    public boolean updateObject(Exam exam) {
        return super.updateObject(exam);
    }


    public boolean deleteObject(int id) {
        return super.deleteObject(id, Exam.class);
    }


    public boolean isObjectInDatabase(int id) {
        return super.isObjectInDatabase(id, Exam.class);
    }


    public Collection<Exam> getAllObjects() {
        return super.getAllObjects(Exam.class);
    }
}
