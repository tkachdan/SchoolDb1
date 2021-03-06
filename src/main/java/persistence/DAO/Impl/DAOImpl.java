package persistence.DAO.Impl;

/**
 * Created by dan on 26.2.15.
 */

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import persistence.DAO.DAO;
import persistence.model.AbstractEntity;
import utils.HibernateService;

import java.util.Collection;
import java.util.List;

public abstract class DAOImpl<T extends AbstractEntity> implements DAO<T> {

    @Override
    public int createObject(T t) {
        try {
            Session session = HibernateService.getSession();
            session.beginTransaction();

            session.save(t);
            session.getTransaction().commit();
            session.close();
            return t.getId();
        }catch (ConstraintViolationException exception){
            return -1;
        }
    }

    @Override
    public T readObjectById(int id, Class<T> tClass) {
        Session session = HibernateService.getSession();
        session.beginTransaction();


        T t = (T) session
                .createQuery("from " + tClass.getSimpleName() + " where id = :itemId")
                .setLong("itemId", id).uniqueResult();

        session.getTransaction().commit();
        session.close();
        return t;
    }

    @Override
    public boolean updateObject(T t) {
        Session session = HibernateService.getSession();
        session.beginTransaction();

        session.update(t);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteObject(int id, Class<T> tClass) {
        Session session = HibernateService.getSession();
        session.beginTransaction();

        T t = (T) session.load(tClass, id);
        session.delete(t);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    public boolean isObjectInDatabase(int id, Class<T> tClass) {
        if (this.readObjectById(id, tClass) == null)
            return false;
        else
            return true;
    }

    public Collection<T> getAllObjects(Class<T> tClass) {
        Session session = HibernateService.getSession();
        session.beginTransaction();

        List objects = session.createQuery("from " + tClass.getSimpleName()).list();

        session.close();
        return objects;
    }

}

