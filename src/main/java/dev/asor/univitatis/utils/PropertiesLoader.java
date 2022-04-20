package dev.asor.univitatis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dev.asor.univitatis.messages.exceptions.utils.PropertiesLoaderException;
import dev.asor.univitatis.messages.exceptions.utils.errors.PropertiesLoaderExceptionEnum;

/**
 * @class PropertiesLoader
 * @author dev.asor
 * @since april.2022
 */
public class PropertiesLoader
{
    private final String resourcePath = "/configs/";
           
    /**
     * Carrega arquivos de configuracao armazenados em '/resources/configs'
     * @param filename : nome do arquivo de config
     * @return 
     */
    public Properties loadProperties(String filename)
    {
        try(InputStream input = PropertiesLoader.class.getResourceAsStream(this.getResourcePath()+filename))
        {
            Properties properties = new Properties();
            if(input != null)
            {
                properties.load(input);
                return properties;
            }
            else
            {
                throw new PropertiesLoaderException(PropertiesLoaderExceptionEnum.ERROR_PROPERTIES_NOT_FOUND.getMessage());
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String getResourcePath()
    {
        return resourcePath;
    }
}
