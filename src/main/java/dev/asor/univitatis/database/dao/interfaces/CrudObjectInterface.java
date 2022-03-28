package dev.asor.univitatis.database.dao.interfaces;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * A finalidade dessa interface e fazer com que a classe de DAO implemente os
 *  metodos basicos de CRUD
 * 
 * @interface CrudObjectInterface
 * @author dev.asor
 * @since 17.march.2022
 */
public interface CrudObjectInterface<T>
{
    void insert(T object, Boolean rollback);
    
    T fetchById(Integer id);
    
    Integer getNextId();
    
    Integer getLastUsedId();

    EntityEnum getEntity();
}
