package dev.asor.univitatis.model.interfaces;

import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * @author dev.asor
 * @sinde 15.mar.2022
 */
public interface PessoaInterface 
{
    public EntityEnum getEntity();
    
	public Integer getNextId();
	public Integer getLastOccupiedId();
}
