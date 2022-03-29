package dev.asor.univitatis.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.GenericHelper;
import dev.asor.univitatis.database.dao.interfaces.GenericConnectorInterface;
import dev.asor.univitatis.database.exceptions.GenericDaoException;
import dev.asor.univitatis.database.exceptions.errors.GenericErrors;

/**
 * Implementa metodos padronizados que serao comum a todas as classes de DAO
 * 	 e podem ser herdados de forma dinamica
 * 
 * @class GenericDao
 * @author dev.asor
 * @since 17.march.2022
 */
public abstract class GenericDao implements GenericConnectorInterface
{    
	private DatabaseConnector connector = null;

	/**
     * Retorna o conector da base de dados
     * @method getConnector
     * @return DatabaseConnector
     */
    @Override
    public DatabaseConnector getConnector()
    {
        return this.connector;
    }
    
	/**
	 * Fixa o conector da base de dados
	 * @param DatabaseConnector connector
	 * @return void
	 */
    @Override
    public void setConnector(DatabaseConnector connector)
    {
        this.connector = connector;
    }
    
    /**
     * Fecha a conexao com o banco de dados
     * @method closeConnection
     * @return void
     */
    @Override
    public void closeConnection()
    {
        this.connector.closeConnection();
    }
    
    /**
     * Retorna último Id na sequencia da entidade de Pessoas
     * @method getLastUsedId
     * @param EntityEnum entity
     * @return Integer
     */
    @Override
    public Integer getLastUsedId(EntityEnum entity)
    {
       Integer id = null;
       String sql = GenericHelper.getLastUsedIdStatement(entity);
       try
       {
           PreparedStatement statement = getConnector().getConnection()
                                                       .prepareStatement(sql);
           
           ResultSet result = statement.executeQuery();
           while(result.next())
           {
               id = result.getInt(1);
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       
       return id;
    }

   /**
    * Retorna próximo Id na sequencia da entidade de Pessoas
    * @method getNextId
    * @param EntityEnum entity
    * @return Integer
    */
    @Override
    public Integer getNextId(EntityEnum entity)
    {
        Integer id = null;
        String sql = GenericHelper.getNextIdStatement(entity);
        try
        {
            PreparedStatement statement = getConnector().getConnection()
                                                        .prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                id = result.getInt(1);
            }
            
            if(id == null)
            {
                throw new GenericDaoException(GenericErrors.ERROR_FETCHING_NEXT_ID.getMessage());
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return id != 0 ? id : 1;
    }
}
