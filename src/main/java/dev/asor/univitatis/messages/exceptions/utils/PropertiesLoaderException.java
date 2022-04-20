package dev.asor.univitatis.messages.exceptions.utils;

/**
 * Excecoes customizadas para o DAO de PropertiesLoader
 * 
 * @class PropertiesLoaderException
 * @author dev.asor
 * @since april.2022
 */
public class PropertiesLoaderException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PropertiesLoaderException(String message)
    {
        super(message);
    }
}
