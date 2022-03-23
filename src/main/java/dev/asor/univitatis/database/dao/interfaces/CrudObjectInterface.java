package dev.asor.univitatis.database.dao.interfaces;

/**
 * A finalidade dessa interface e fazer com que a classe de DAO implemente os
 *  metodos basicos de CRUD
 * 
 * @author dev.asor
 * @since 17.march.2022
 */
public interface CrudObjectInterface<T>
{
    public void insert(T object);
    
    public T fetchById(Integer id);
    
    public Integer getNextId();
    
    public Integer getLastUsedId();
}
