package dev.asor.univitatis.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import dev.asor.univitatis.database.connector.interfaces.DatabaseConnectorInterace;
import dev.asor.univitatis.messages.exceptions.dao.GenericDaoException;
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
    private Boolean isAutoCommit  = false;
    
    private DatabaseConnector()
    {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties properties = propertiesLoader.loadProperties("dbconfig.properties");
        try
        {
            Class.forName(properties.getProperty("db.class"));
            
            if(connection == null) {
                tryConnection();
            }
            
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
        finally /* msg connection successful */
        {
            //System.out.println(DatabaseConnectorMessages.SUCCESS_CONNECTION_DATABASE.getMessage());  
        }
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
            Logger.getLogger(DatabaseConnector.class.getName());
            throw new GenericDaoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
        }
    }
    
    @Override
    public Connection getConnection()
    {
        if(this.connection == null)
        {
            tryConnection();
        } 
        else
        {  
            try
            {
                if(this.connection.isClosed())
                {
                    tryConnection();
                }
            } 
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        
        return this.connection;
    }
 
    /**
     * Realiza tentativa de conexao ao banco de dados
     */
    private Connection tryConnection()
    {
        try
        {
            if(this.connection == null || this.connection.isClosed())
            {
                try
                {
                    PropertiesLoader propertiesLoader = new PropertiesLoader();
                    Properties properties = propertiesLoader.loadProperties("dbconfig.properties");

                    this.connection 
                        = DriverManager
                            .getConnection( properties.getProperty("db.driver") 
                                          + getClass().getResource(properties.getProperty("db.url")));
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       
       return this.connection; 
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
