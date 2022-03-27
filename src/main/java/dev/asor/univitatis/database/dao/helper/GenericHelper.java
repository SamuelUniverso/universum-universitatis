package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * @class GenericHelper
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericHelper 
{
	/**
	 * Gera Statement para o CRUD do DAO buscar o último Id usado pela entidade
	 * @method getLastUsedIdStatement
	 * @param EntityEnum entity
	 * @return String
	 */
	public static String getLastUsedIdStatement(EntityEnum entity)
    {
        return "SELECT max(id) FROM " + entity.getEntityName() + " LIMIT 1";
    }
    
	/**
	 * Gera Statement para o CRUD do DAO gerar o próximo Id a ser usado pela entidade
	 * @method getNextIdStatement
	 * @param EntityEnum entity
	 * @return String
	 */
    public static String getNextIdStatement(EntityEnum entity)
    {
        return "SELECT max(id)+1 FROM " + entity.getEntityName() + " LIMIT 1";
    }
}
