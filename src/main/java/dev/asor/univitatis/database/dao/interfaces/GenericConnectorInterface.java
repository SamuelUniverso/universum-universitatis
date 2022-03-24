package dev.asor.univitatis.database.dao.interfaces;

import dev.asor.univitatis.database.connector.DatabaseConnector;

/**
 * A finalidade dessa interface e fazer com que a classe de DAO implemente o
 *  conector do banco de dados
 *  
 * @author dev.asor
 * @since 17.march.2022
 */
public interface GenericConnectorInterface
{
    public DatabaseConnector getConnector();
    
    public void setConnector(DatabaseConnector connector);
    
    public void closeConnection();
}
