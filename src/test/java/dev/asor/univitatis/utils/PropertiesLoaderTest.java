package dev.asor.univitatis.utils;

import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import dev.asor.univitatis.utils.PropertiesLoader;

public class PropertiesLoaderTest
{
    @Test
    public void testDatabaseConfigLoading()
    {
        PropertiesLoader loader = new PropertiesLoader();
        Properties prop = loader.loadProperties("dbconfig.properties");
        
        String dbDriver = prop.getProperty("db.driver");
        String dbClass  = prop.getProperty("db.class"); 
        String dbUrl    = prop.getProperty("db.url");
        String dbUser   = prop.getProperty("db.user");
        String dbPass   = prop.getProperty("db.pass");
        
        System.out.println(dbDriver);
        System.out.println(dbClass);
        System.out.println(dbUrl);
        System.out.println(dbUser);
        System.out.println(dbPass);
    }
}
