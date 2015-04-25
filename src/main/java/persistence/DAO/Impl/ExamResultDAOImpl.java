package persistence.DAO.Impl;

import persistence.model.ExamResult;

import java.util.Collection;

/**
 * Created by martin on 25.4.15.
 */
public class ExamResultDAOImpl extends DAOImpl<ExamResult> {
    @Override
    public int createObject(ExamResult examResult) {
        return super.createObject(examResult);
    }


    public ExamResult readObjectById(int id) {
        return super.readObjectById(id, ExamResult.class);
    }

    @Override
    public boolean updateObject(ExamResult examResult) {
        return super.updateObject(examResult);
    }


    public boolean deleteObject(int id) {
        return super.deleteObject(id, ExamResult.class);
    }

    public boolean isObjectInDatabase(int id) {
        return super.isObjectInDatabase(id, ExamResult.class);
    }

    public Collection<ExamResult> getAllObjects() {
        return super.getAllObjects(ExamResult.class);
    }
}
