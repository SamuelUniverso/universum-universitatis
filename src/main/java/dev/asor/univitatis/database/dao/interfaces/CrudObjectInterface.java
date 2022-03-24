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
	//void insert(T object);
    
    Integer insert(T object, Boolean debug);
    
    T fetchById(Integer id);
    
    Integer getNextId();
    
    Integer getLastUsedId();

}
