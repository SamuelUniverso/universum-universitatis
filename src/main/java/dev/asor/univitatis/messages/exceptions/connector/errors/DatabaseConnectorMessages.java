package dev.asor.univitatis.messages.exceptions.connector.errors;

/**
 * @enum DatabaseConnectorMessages
 * @author dev.asor
 * @since april.2022
 */
public enum DatabaseConnectorMessages
{
    SUCCESS_CONNECTION_DATABASE("Conexão com o Banco de Dados bem sucedida!")
   ;
   
   private String message;
   
   DatabaseConnectorMessages(String message)
   {
       this.message = message;
   }
   
   public String getMessage()
   {
       return this.message;
   }
}
