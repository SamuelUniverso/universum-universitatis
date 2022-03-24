package dev.asor.univitatis.database.exceptions.errors;

public enum PessoaExceptionMessages
{
      ERROR_INSERT_PESSOA ("Erro ao inserir Pessoa!")
    , ERRRO_FETCH_BY_ID   ("Erro ao buscar Pessoa pelo id!")
    ;
    
    private String message;
    
    PessoaExceptionMessages(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        return this.message;
    }
}
