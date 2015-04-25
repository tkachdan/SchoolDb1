package persistence.DAO.Impl;

import persistence.model.Assignment;

import java.util.Collection;

/**
 * Created by martin on 25.4.15.
 */
public class AssignmentDAOImpl extends DAOImpl<Assignment> {
    @Override
    public int createObject(Assignment assignment) {
        return super.createObject(assignment);
    }

    public Assignment readObjectById(int id) {
        return super.readObjectById(id, Assignment.class);
    }

    @Override
    public boolean updateObject(Assignment assignment) {
        return super.updateObject(assignment);
    }

    public boolean deleteObject(int id ) {
        return super.deleteObject(id, Assignment.class);
    }

    public boolean isObjectInDatabase(int id ) {
        return super.isObjectInDatabase(id, Assignment.class);
    }

    public Collection<Assignment> getAllObjects( ) {
        return super.getAllObjects(Assignment.class);
    }
}
