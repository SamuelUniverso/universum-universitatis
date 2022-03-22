package dev.asor.univitatis.database.connector;

import org.junit.Test;

/**
 * @author dev.asor
 * @since 16.mar.2022
 */
public class ConnectorTest
{
    @Test
    public void testConnection()
    {
        DatabaseConnector conexao = DatabaseConnector.getInstance();
        conexao.closeConnection();
    }
}
