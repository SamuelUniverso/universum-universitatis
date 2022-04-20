package dev.asor.univitatis.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dev.asor.univitatis.database.connector.interfaces.DatabaseConnectorInterace;
import dev.asor.univitatis.messages.exceptions.connector.errors.DatabaseConnectorMessages;
import dev.asor.univitatis.messages.exceptions.dao.GenericDaoException;
import dev.asor.univitatis.messages.exceptions.dao.PessoaException;
import dev.asor.univitatis.messages.exceptions.dao.errors.GenericErrors;
import dev.asor.univitatis.utils.PropertiesLoader;

/**
 * Implementa o driver basico do conector JDBC
 * 
 * @class DatabaseConnector
 * @author dev.asor
 * @since march.2022
 */
public class DatabaseConnector implements DatabaseConnectorInterace
{
    private static DatabaseConnector INSTANCE = null;
    private Connection connection = null;
    private Boolean isAutoCommit = false;
    
    private DatabaseConnector() 
    {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties properties = propertiesLoader.loadProperties("dbconfig.properties");
        try
        {
            Class.forName(properties.getProperty("db.class"));
            connection = DriverManager
                             .getConnection( properties.getProperty("db.driver") 
                                           + getClass().getResource(properties.getProperty("db.url")));
            connection.setAutoCommit(isAutoCommit);
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println(DatabaseConnectorMessages.SUCCESS_CONNECTION_DATABASE.getMessage());  
        }
    }
    
    public Connection getConnection()
    {
       return this.connection; 
    }
    
    /*
     * Encerra conexão da instancia 
     * @method closeConnection
     * @return void
     * @throws GenericDaoException
     */
    @Override
    public void closeConnection()
    {
        try
        {
            this.connection.close();
            DatabaseConnector.INSTANCE = null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new GenericDaoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
        }
    }

    /**
     * Traz instancia do conector do banco
     * @notice Singleton
     * @method getInstance
     * @return DatabaseConnector
     */
    public static DatabaseConnector getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new DatabaseConnector();
        }
        
        return INSTANCE;
    }
}
