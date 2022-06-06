package dev.asor.univitatis.database.dao.utils;

import org.junit.Test;
import dev.asor.univitatis.database.connector.DatabaseConnector;

public class DatabaseInitializerTest
{
    @Test
    public void createEmptyDbFile()
    {
        DatabaseConnector connector = DatabaseConnector.getInstance();
        connector.getDriverResourcePath();

        DatabaseInitializer db = new DatabaseInitializer();
    }
    
    @Test
    public void instantiateEntities()
    {
        DatabaseInitializer db = new DatabaseInitializer();
        db.instantiateEntities();
    }

    @Test
    public void checkDatabase()
    {
        DatabaseInitializer db = new DatabaseInitializer();
        if(!db.checkDatabase())
        {
            db.instantiateEntities();
        }
    }
}
