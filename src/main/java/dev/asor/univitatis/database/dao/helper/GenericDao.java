package dev.asor.univitatis.database.dao.helper;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.interfaces.GenericConnectorInterface;

/**
 * Implementa metodos padronizados que serao comum a todas as classes de DAO
 *  e podem ser herdados de forma dinamica
 *  
 * @author dev.asor
 * @since 17.march.2022
 */
public abstract class GenericDao implements GenericConnectorInterface
{    
	private DatabaseConnector connector = null;
	private Integer generatedId = null;

	 /**
     * Gerenciamento do conector do banco de dados
     */
    @Override
    public DatabaseConnector getConnector()
    {
        return this.connector;
    }
    @Override
    public void setConnector(DatabaseConnector connector)
    {
        this.connector = connector;
    }
    @Override
    public void closeConnection()
    {
        this.connector.closeConnection();
    }
    
    public Integer getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId(Integer generatedId) {
		this.generatedId = generatedId;
	}
	
	public static String getLastUsedIdStatement(EntityEnum entity)
    {
        return "SELECT max(id) FROM " + entity.getEntityName() + " LIMIT 1";
    }
    
    public static String getNextIdStatement(EntityEnum entity)
    {
        return "SELECT max(id)+1 FROM " + entity.getEntityName() + " LIMIT 1";
    }
}
