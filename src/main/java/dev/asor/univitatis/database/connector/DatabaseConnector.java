package dev.asor.univitatis.database.connector;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

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
    
    private Properties configurations;
    
    private DatabaseConnector()
    {
        try
        {
            Class.forName(loadConfigurations().getProperty("db.class"));

            if(!isConnection()) {
                attemptDatabaseConnection();
            }

            getConnection().setAutoCommit(isAutoCommit);
        } 
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
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
            e.printStackTrace();
            Logger.getLogger(DatabaseConnector.class.getName());
            throw new GenericDaoException(GenericErrors.ERROR_CLOSE_CONNECTION.getMessage());
        }
    }
    
    @Override
    public Connection getConnection()
    {
        if(!isConnection())
        {
            attemptDatabaseConnection();
        } 

        return getDatabaseDriver();
    }
 
    /**
     * Faz tentativa de conexao com o banco de dados
     * @return Connection
     */
    public Connection attemptDatabaseConnection()
    {
        if(!isConnection())
        {
            try
            {
                setDatabaseDriver(DriverManager.getConnection(getDriverResourcePath()));
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        
        return getDatabaseDriver();
    }
    
    /**
     * Cria novo arquivo SQLite
     * @return void
     */
    public void createEmptyDatabaseFile()
    {
        try
        {
            DatabaseConnector connector = DatabaseConnector.getInstance();
            String path = connector.getDriverResourceFullPath();

            FileUtils.touch(new File(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Mostra o diretorio completo ate o arquivo da base SQLite
     * @return String
     */
    public String getDriverResourceFullPath()
    {
        StringBuilder path = new StringBuilder();
        
        path.append(getClass().getResource("/database/").getPath());
        path.append(configurations.getProperty("db.name"));
        
        return path.toString();
    }
    
    /**
     * Traz o caminho de recurso do arquivo SQLite
     * @return String
     */
    public String getDriverResourcePath()
    {
        StringBuilder path = new StringBuilder();

        path.append(loadConfigurations().getProperty("db.driver"));
        path.append(getClass().getResource(configurations.getProperty("db.url")));

        return path.toString();
    }
    
    /**
     * Retorna o driver conector da base de dados
     * @return Connection
     */
    public Connection getDatabaseDriver()
    {
        if(!isConnection()) {
            attemptDatabaseConnection();
        }

        return this.connection;
    }
    
    private void setDatabaseDriver(Connection connection)
    {
        this.connection = connection;
    }
    
    /**
     * Verifica se conexao com o banco de dados esta ativa
     * @return boolean
     */
    public boolean isConnection()
    {
        try 
        {
            return (this.connection == null || this.connection.isClosed()) ? false : true;
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * Carrega configuracoes do ambiente
     * @return Properties
     */
    private Properties loadConfigurations()
    {
        if(this.configurations != null) {
            return this.configurations;
        }

        try
        {
            PropertiesLoader propertiesLoader = new PropertiesLoader();
            this.configurations = propertiesLoader.loadProperties("dbconfig.properties");

            return this.configurations;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
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
