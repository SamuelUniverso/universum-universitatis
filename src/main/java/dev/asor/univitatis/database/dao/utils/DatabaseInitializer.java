package dev.asor.univitatis.database.dao.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import dev.asor.univitatis.database.connector.DatabaseConnector;
import dev.asor.univitatis.database.dao.enums.EntityEnum;
import dev.asor.univitatis.database.dao.helper.DatabaseInitializerHelper;

/**
 * @author dev.asor
 * @since may.2022
 */
public class DatabaseInitializer
{
    public void instantiateEntities()
    {
        createEmptyDatabaseFile();

        try
        {
            DatabaseConnector db = DatabaseConnector.getInstance();
            Connection conn = db.getConnection();

            conn.setAutoCommit(false);
            conn.beginRequest();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(DatabaseInitializerHelper.getDataBaseCreationStatement());

            conn.commit();
            stmt.close();

            db.closeConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            Logger.getLogger(DatabaseInitializer.class.getName());
        }
    }

    /**
     * Verifica se a quantidade de entidades no Banco
     *  corresponde ao numero total
     */
    public boolean checkDatabase()
    {
        int cumulator = 0;

        try
        {
            DatabaseConnector conn = DatabaseConnector.getInstance();
            DatabaseMetaData dbmeta = conn.getConnection().getMetaData();
            ResultSet result = null;

            EntityEnum[] vals = EntityEnum.values();
            for(int i = 0; i < EntityEnum.values().length; i++)
            {
                result = dbmeta.getTables(null, null, vals[i].getEntityName(), null);
                while(result.next())
                {
                    if(result.getRow() > 0) {
                        cumulator++;
                    }
                }
            }
            if(cumulator == EntityEnum.values().length) 
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            Logger.getLogger(DatabaseInitializer.class.getName());
        }
        
        return false;
    }
    
    private void createEmptyDatabaseFile()
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
}
