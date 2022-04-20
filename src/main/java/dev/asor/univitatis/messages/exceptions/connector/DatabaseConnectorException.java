package dev.asor.univitatis.messages.exceptions.connector;

/**
 * Excecoes customizadas para o DatabaseConenctor
 * 
 * @class DatabaseConnectorException
 * @author dev.asor
 * @since april.2022
 */
public class DatabaseConnectorException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public DatabaseConnectorException(String message)
    {
        super(message);
    }
}
