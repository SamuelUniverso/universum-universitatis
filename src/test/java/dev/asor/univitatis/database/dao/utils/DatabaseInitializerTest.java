package dev.asor.univitatis.database.dao.utils;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import dev.asor.univitatis.database.connector.DatabaseConnector;

public class DatabaseInitializerTest
{
    
    @Test
    public void instantiateEntities()
    {
        createEmptyDatabaseFile();

        //DatabaseInitializer db = new DatabaseInitializer();
        //db.instantiateEntities();
        //if(!checkDatabase()) 
        //{
        //   db.instantiateEntities();
        //}
    }

    private void createEmptyDatabaseFile()
    {
        try
        {
            String path = DatabaseConnector.getDriverResourceFolder();
            
            File file = new File(path);
            
            file.canWrite();
            file.canRead();
            
            file.createNewFile();
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
