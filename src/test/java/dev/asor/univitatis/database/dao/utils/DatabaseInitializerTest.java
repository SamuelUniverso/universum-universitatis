package dev.asor.univitatis.database.dao.utils;

import org.junit.Test;

public class DatabaseInitializerTest
{
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
