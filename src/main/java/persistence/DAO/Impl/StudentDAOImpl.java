package persistence.DAO.Impl;

import persistence.model.Student;

import java.util.Collection;

/**
 * Created by dan on 11.3.15.
 */
public class StudentDAOImpl extends DAOImpl<Student> {
    @Override
    public int createObject(Student student) {
        return super.createObject(student);
    }


    public Student readObjectById(int id) {
        return super.readObjectById(id, Student.class);
    }

    @Override
    public boolean updateObject(Student student) {
        return super.updateObject(student);
    }

    public boolean deleteObject(int id) {
        return super.deleteObject(id, Student.class);
    }

    public boolean isObjectInDatabase(int id) {
        return super.isObjectInDatabase(id, Student.class);
    }

    public Collection<Student> getAllObjects() {
        return super.getAllObjects(Student.class);
    }
}
