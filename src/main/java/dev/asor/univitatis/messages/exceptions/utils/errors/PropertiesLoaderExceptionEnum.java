package dev.asor.univitatis.messages.exceptions.utils.errors;

/**
 * @enum PropertiesLoaderExceptionEnum
 * @author dev.asor
 * @since april.2022
 */
public enum PropertiesLoaderExceptionEnum 
{
      ERROR_PROPERTIES_NOT_FOUND  ("Properties não encontradas!")
    ;
  
    private String message;
  
    PropertiesLoaderExceptionEnum(String message)
    {
        this.message = message;
    }
  
    public String getMessage()
    {
      return this.message;
    }
}
