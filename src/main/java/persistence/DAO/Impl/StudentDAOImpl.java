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

    @Override
    public boolean deleteObject(int id, Class<Student> studentClass) {
        return super.deleteObject(id, studentClass);
    }

    @Override
    public boolean isObjectInDatabase(int id, Class<Student> studentClass) {
        return super.isObjectInDatabase(id, studentClass);
    }

    @Override
    public Collection<Student> getAllObjects(Class<Student> studentClass) {
        return super.getAllObjects(studentClass);
    }
}
