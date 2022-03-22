package dev.asor.univitatis.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author dev.asor
 * @since 15.mar.2022
 */
public class DatabaseConnector
{
    private static DatabaseConnector INSTANCE = null;
    private Connection connection = null;
    
    private static final String SQLITE_JDBC = "jdbc:sqlite:";
    private static final String DATABASE_PATH = "/database/app.database.db"; 
    
    private static String url = null;


    private DatabaseConnector() 
    {
        try
        {
            setUrl(SQLITE_JDBC + getClass().getResource(DATABASE_PATH));
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            
            System.out.println("Conexão com o Banco de Dados bem sucedida!");
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    
    private static void setUrl(String url)
    {
        DatabaseConnector.url = url;
    }
    public String getUrl()
    {
        return url;
    }
    
    public Connection getConexao()
    {
       return this.connection; 
    }
    
    /*
     * Encerra conexão da instancia 
     * @method closeConnection()
     * @return void
     */
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
        }
    }

    /**
     * Traz instancia do conector do banco
     * @notice Singleton
     * @method getInstance()
     * @return Connector
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
