package dev.asor.univitatis.database.dao.util;

import dev.asor.univitatis.database.connector.ConectorBanco;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public class GenericConnector 
{
	protected ConectorBanco conector;
	
	public GenericConnector()
	{
		setConector(ConectorBanco.getInstance());
	}
	
	protected ConectorBanco getConector()
    {
        return conector;
    }
	protected void setConector(ConectorBanco conector)
    {
        this.conector = conector;
    }
}
