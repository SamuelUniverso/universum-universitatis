package dev.asor.univitatis.database.dao.interfaces;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public interface DaoObjectInterface<T>
{
    public void insert(T object);
    
    public T fetchById(Integer id);
}
