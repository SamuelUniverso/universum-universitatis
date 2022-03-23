package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * Implementa metodos padronizados que serao comum a todas as classes de DAO
 *  e podem ser herdados de forma dinamica
 *  
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericDao
{
    public static String getLastUsedIdStatement(EntityEnum entity)
    {
        return "SELECT max(id) FROM " + entity.getEntityName() + " LIMIT 1";
    }
    
    public static String getNextIdStatement(EntityEnum entity)
    {
        return "SELECT max(id)+1 FROM " + entity.getEntityName() + " LIMIT 1";
    }
}
