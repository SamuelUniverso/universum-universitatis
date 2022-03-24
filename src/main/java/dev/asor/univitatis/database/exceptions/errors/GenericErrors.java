package dev.asor.univitatis.database.exceptions.errors;

/**
 * @author dev.asor
 * @since 17.march.2022
 */
public enum GenericErrors 
{
   ERROR_CLOSE_CONNECTION ("Erro ao encerrar conexao com o Banco de Dados!");
  ;
  
  private String message;
  
  GenericErrors(String message)
  {
      this.message = message;
  }
  
  public String getMessage()
  {
      return this.message;
  }
}
