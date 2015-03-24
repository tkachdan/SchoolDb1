package persistence.DAO;

/**
 * Created by dan on 26.2.15.
 */



import persistence.model.AbstractEntity;

import java.util.Collection;

public interface DAO<T extends AbstractEntity> {
    public int createObject(T t);

    public T readObjectById(int id, Class<T> tClass);

    public boolean updateObject(T t);

    public boolean deleteObject(int id, Class<T> tClass);

    public Collection<T> getAllObjects(Class<T> tClass);
}
