package persistence.DAO.Impl;

import persistence.model.Teacher;

import java.util.Collection;

/**
 * Created by martin on 25.4.15.
 */
public class TeacherDAOImpl extends DAOImpl<Teacher> {
    @Override
    public int createObject(Teacher teacher) {
        return super.createObject(teacher);
    }

    public Teacher readObjectById(int id) {
        return super.readObjectById(id,Teacher.class);
    }

    @Override
    public boolean updateObject(Teacher teacher) {
        return super.updateObject(teacher);
    }

    public boolean deleteObject(int id) {
        return super.deleteObject(id, Teacher.class);
    }

    public boolean isObjectInDatabase(int id) {
        return super.isObjectInDatabase(id, Teacher.class);
    }

    public Collection<Teacher> getAllObjects() {
        return super.getAllObjects(Teacher.class);
    }
}
