package dev.asor.univitatis.database.dao.util;

import dev.asor.univitatis.database.connector.DatabaseConnector;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericConnector 
{
	protected DatabaseConnector conector;
	
	public GenericConnector()
	{
		setConector(DatabaseConnector.getInstance());
	}
	
	protected DatabaseConnector getConector()
    {
        return conector;
    }
	protected void setConector(DatabaseConnector conector)
    {
        this.conector = conector;
    }
}
