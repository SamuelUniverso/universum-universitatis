package dev.asor.univitatis.database.exceptions.errors;

/**
 * @enum GenericErrors
 * @author dev.asor
 * @since 17.march.2022
 */
public enum GenericErrors 
{
    ERROR_CLOSE_CONNECTION      ("Erro ao encerrar conexao com o Banco de Dados!")
  , ERROR_END_TRANSACTION       ("Erro ao realizar a transação com o Banco de Dados")
  , ERROR_FETCHING_NEXT_ID      ("Erro ao buscar pelo próximo ID da sequência")
  , ERROR_ROLLBAK_CONNECTION    ("Erro na transação, realizando rollback...")
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
