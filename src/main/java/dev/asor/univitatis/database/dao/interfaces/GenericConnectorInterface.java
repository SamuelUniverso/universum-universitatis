package dev.asor.univitatis.database.dao.interfaces;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;

/**
 * A finalidade dessa interface e fazer com que a classe de DAO implemente o
 *  conector do banco de dados
 *  
 * @interface GenericConnectorInterface
 * @author dev.asor
 * @since 17.march.2022
 */
public interface GenericConnectorInterface
{
    DatabaseConnector getConnector();
    
    void setConnector(DatabaseConnector connector);
    
    void closeConnection();

    Integer getNextId(EntityEnum entity);

    Integer getLastUsedId(EntityEnum entity);
}
