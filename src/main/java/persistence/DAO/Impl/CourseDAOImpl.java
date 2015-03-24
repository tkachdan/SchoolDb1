package persistence.DAO.Impl;



import persistence.model.Course;

import java.util.Collection;

/**
 * Created by dan on 24.3.15.
 */
public class CourseDAOImpl extends DAOImpl<Course> {
    @Override
    public int createObject(Course course) {
        return super.createObject(course);
    }

    public Course readObjectById(int id) {
        return super.readObjectById(id, Course.class);
    }

    @Override
    public boolean updateObject(Course course) {
        return super.updateObject(course);
    }

    public boolean deleteObject(int id) {
        return super.deleteObject(id, Course.class);
    }

    public boolean isObjectInDatabase(int id) {
        return super.isObjectInDatabase(id, Course.class);
    }

    public Collection<Course> getAllObjects() {
        return super.getAllObjects(Course.class);
    }
}
