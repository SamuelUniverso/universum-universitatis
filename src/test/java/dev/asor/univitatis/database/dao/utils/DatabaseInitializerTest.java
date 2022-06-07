package dev.asor.univitatis.database.dao.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import dev.asor.univitatis.database.connector.DatabaseConnector;

public class DatabaseInitializerTest
{
    
    @Test
    public void instantiateEntities()
    {
        DatabaseInitializer db = new DatabaseInitializer();
        //if(!checkDatabase()) 
        //{
            createEmptyDatabaseFile();
            db.instantiateEntities();
       //}
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
    
    public boolean checkDatabase()
    {
        DatabaseInitializer db = new DatabaseInitializer();
        return db.checkDatabase();
    }
}
