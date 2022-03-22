package dev.asor.univitatis.database.dao.util;

import dev.asor.univitatis.database.connector.DatabaseConnector;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericConnector 
{
	protected DatabaseConnector connector;
	
	public GenericConnector()
	{
		setConnector(DatabaseConnector.getInstance());
	}
	
	protected DatabaseConnector getConnector()
    {
        return connector;
    }
	protected void setConnector(DatabaseConnector connector)
    {
        this.connector = connector;
    }
}
